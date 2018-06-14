package io.evotor.market.api.exception;

import lombok.Data;

import java.util.List;

@Data
public class BadRequestException extends RuntimeException {

    private String code;
    private String message;
    private List<Violation> violations;

}
