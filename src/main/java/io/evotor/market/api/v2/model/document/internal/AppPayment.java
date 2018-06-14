package io.evotor.market.api.v2.model.document.internal;

import lombok.Data;

import java.util.UUID;

@Data
public class AppPayment {

    private UUID appId;
    private String name;

}
