package io.evotor.market.api.v2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import feign.*;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import io.evotor.market.api.exception.ExceptionResolver;
import io.evotor.market.api.v2.builder.Api;
import io.evotor.market.api.v2.model.GUID;
import net.javacrumbs.jsonunit.JsonMatchers;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Type;
import java.util.*;

public class ApiHolder {

    public static final GUID STORE = new GUID(new UUID(0L, 1L));
    public static final UUID DEFAULT = new UUID(0L, 1L);

    public static Api api = new ApiV2(Feign.builder()
            .encoder(new ValidationEncoder())
            .decoder(new JacksonDecoder(getObjectMapper()))
            .logger(new Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .client(getClient())
            .requestInterceptor(template -> {
                template.header("User-Agent", "Api-Tests");
                template.header("Accept", "application/vnd.evotor.v2+json");
            })
            .errorDecoder(new ExceptionResolver()),
            "dummy").build();

    private static ObjectMapper getObjectMapper() {
        return new ObjectMapper()
                .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .setPropertyNamingStrategy(new PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy());
    }

    private static Client getClient() {
        ObjectMapper mapper = getObjectMapper();
        return (request, options) -> {
            String path = StringUtils.substringAfter(request.url(), "dummy");

            int index = path.lastIndexOf("/");
            String prefix = path.substring(0, index) + "/" + request.method() + " " + path.substring(index + 1);
            String updated = StringUtils.removeAll(prefix, "00000000-0000-0000-0000-00000000000");

            InputStream inputStream = ApiHolder.class.getResourceAsStream(updated + ".in.json");
            if (inputStream != null) {
                JsonNode expected = mapper.readTree(inputStream);
                JsonNode actual = mapper.readTree(request.body());

                Assert.assertThat(expected, JsonMatchers.jsonEquals(actual));
            }

            InputStream outputStream = ApiHolder.class.getResourceAsStream(updated + ".json");
            if (outputStream == null) {
                return Response.builder()
                        .status(404)
                        .headers(Collections.emptyMap())
                        .build();
            }

            int statusCode = 200;
            byte[] bytes = Util.toByteArray(outputStream);
            LineNumberReader reader = new LineNumberReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
            String firstLine = reader.readLine();
            if (firstLine != null && firstLine.startsWith("// HTTP/1.1")) {
                String code = firstLine.substring(12, 15);
                statusCode = Integer.parseInt(code);
                bytes = Arrays.copyOfRange(bytes, firstLine.length(), bytes.length);
            }

            return Response.builder()
                    .status(statusCode)
                    .body(bytes)
                    .headers(new HashMap<String, Collection<String>>() {{
                        put("Content-Type", Collections.singleton("application/vnd.evotor.v2+json"));
                    }})
                    .build();
        };
    }

    private static class ValidationEncoder extends JacksonEncoder {

        private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        ValidationEncoder() {
            super(getObjectMapper());
        }

        @Override
        public void encode(Object object, Type bodyType, RequestTemplate template) {
            Set<ConstraintViolation<Object>> violationSet = validator.validate(object);
            if (!violationSet.isEmpty()) {
                throw new ConstraintViolationException(violationSet);
            }

            super.encode(object, bodyType, template);
        }
    }
}
