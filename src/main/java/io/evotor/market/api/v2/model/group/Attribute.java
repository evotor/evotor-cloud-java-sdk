package io.evotor.market.api.v2.model.group;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.UUID;

@Data
@Builder
public class Attribute {

    private UUID id;
    private String name;
    private Collection<AttributeChoice> choices;

}
