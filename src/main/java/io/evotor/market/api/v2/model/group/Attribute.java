package io.evotor.market.api.v2.model.group;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attribute {

    private UUID id;
    private String name;
    private Collection<AttributeChoice> choices;

}
