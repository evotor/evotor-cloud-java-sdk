package io.evotor.market.api.v2.model.group;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ProductGroupUpdateFields {

    private String name;
    private List<@NotBlank String> barcodes;

}
