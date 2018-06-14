package io.evotor.market.api.v2.model.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class SupplierUpdate {

    @Size(min = 1, max = 255)
    private String name;

}
