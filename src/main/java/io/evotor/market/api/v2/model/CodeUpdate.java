package io.evotor.market.api.v2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CodeUpdate {

    @Size(max = 10)
    private String code;

}
