package io.evotor.market.api.v2.model.group;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AttributeChoice {

    private UUID id;
    private String name;

}
