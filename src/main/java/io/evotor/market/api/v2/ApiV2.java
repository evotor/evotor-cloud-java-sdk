package io.evotor.market.api.v2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import feign.Feign;
import feign.Logger;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import io.evotor.market.api.exception.ExceptionResolver;
import io.evotor.market.api.v2.builder.Api;
import io.evotor.market.api.v2.impl.ApiImpl;

public class ApiV2 {

    private final String apiUrl;
    private final Feign.Builder builder;

    public static ApiV2 of(String token) {
        return of(token, "https://api.evotor.ru/");
    }

    public static ApiV2 of(String token, String apiUrl) {
        ObjectMapper mapper = buildObjectMapper();

        return new ApiV2(Feign.builder()
                .decoder(new JacksonDecoder(mapper))
                .encoder(new FormEncoder(new JacksonEncoder(mapper)))
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .client(new OkHttpClient())
                .requestInterceptor(template -> {
                    template.header("X-Authorization", token);
                    template.header("User-Agent", "X-Evotor-Api-Demo");
                    template.header("Accept", "application/vnd.evotor.v2+json");
                    if (template.body() != null && template.body().length > 0 && !template.headers().containsKey("Content-Type")) {
                        template.header("Content-Type", "application/json");
                    }
                })
                .errorDecoder(new ExceptionResolver()), apiUrl);
    }

    public static ObjectMapper buildObjectMapper() {
        return new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .setPropertyNamingStrategy(new PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy());
    }

    public ApiV2(Feign.Builder builder, String apiUrl) {
        this.apiUrl = apiUrl;
        this.builder = builder;
    }

    public Api build() {
        return new ApiImpl(this::buildApi);
    }

    private <T> T buildApi(Class<T> apiType) {
        return builder.target(apiType, apiUrl);
    }
}
