package io.evotor.market.api.v2.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.UUID;

public class GUID {

    private final UUID value;

    @JsonCreator
    public GUID(UUID value) {
        this.value = value;
    }

    @JsonValue
    public UUID asUUID() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString().toUpperCase();
    }
}

