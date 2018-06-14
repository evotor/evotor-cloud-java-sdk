package io.evotor.market.api.exception;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class ExceptionResolver implements ErrorDecoder {

    private final ObjectMapper mapper = new ObjectMapper();

    public RuntimeException of(Response response) {
        switch (response.status()) {
            case 401:   return new InvalidTokenException();
            case 403:   return new InsufficientRightsException();
            case 404:   return new ResourceNotFoundException();
            case 400:
                try {
                    throw mapper.<BadRequestException>readValue(
                            response.body().asInputStream(),
                            new TypeReference<BadRequestException>() {});
                } catch (IOException e) {
                    log.warn("unexpected response body", e);
                }

                return new BadRequestException();
            default:    return new RuntimeException(response.reason());
        }
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        return of(response);
    }
}
