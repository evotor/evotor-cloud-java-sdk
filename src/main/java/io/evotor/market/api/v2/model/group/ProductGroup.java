package io.evotor.market.api.v2.model.group;

import io.evotor.market.api.v2.model.AbstractResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductGroup extends AbstractResource {

    private UUID id;

    private UUID parentId;

    @NotNull
    private String name;

    private List<Attribute> attributes;

    private List<@NotBlank String> barcodes;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        ProductGroup toBuild;

        public Builder() {
            toBuild = new ProductGroup();
        }

        public Builder withName(String name) {
            toBuild.setName(name);
            return this;
        }

        public Builder withParentId(UUID parentId) {
            toBuild.setParentId(parentId);
            return this;
        }

        public Builder withBarCode(String barCode) {
            List<String> barCodes = toBuild.getBarcodes();
            if (barCodes == null) {
                barCodes = new ArrayList<>();
                toBuild.setBarcodes(barCodes);
            }

            barCodes.add(barCode);
            return this;
        }

        public Builder withAttribute(Attribute attribute) {
            List<Attribute> attributes = toBuild.getAttributes();
            if (attributes == null) {
                attributes = new ArrayList<>();
                toBuild.setAttributes(attributes);
            }

            attributes.add(attribute);
            return this;
        }

        public ProductGroup build() {
            return toBuild;
        }
    }
}
