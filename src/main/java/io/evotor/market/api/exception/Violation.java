package io.evotor.market.api.exception;

import lombok.Data;

@Data
public class Violation {

    private String reason;
    private String subject;

}
