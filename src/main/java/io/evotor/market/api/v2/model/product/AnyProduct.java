package io.evotor.market.api.v2.model.product;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.evotor.market.api.v2.model.AbstractResource;
import io.evotor.market.api.v2.model.GUID;
import io.evotor.market.api.v2.model.product.image.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ServiceProduct.class, name = "SERVICE"),
        @JsonSubTypes.Type(value = PhysicalProduct.class, name = "NORMAL"),
        @JsonSubTypes.Type(value = MarkedAlcoholProduct.class, name = "ALCOHOL_MARKED"),
        @JsonSubTypes.Type(value = AlcoholProduct.class, name = "ALCOHOL_NOT_MARKED")
})
@EqualsAndHashCode(callSuper = true)
public abstract class AnyProduct extends AbstractResource {

    @NotNull
    private UUID id;

    @NotBlank
    @Size(max = 128)
    private String name;

    private UUID parentId;

    private List<ProductImage> images;

    @Null
    private GUID storeId;

    @Null
    private String userId;

    public static class Builder<T extends AnyProduct, B extends AnyProduct.Builder<T, ?>> {

        T toBuild;

        Builder(T toBuild) {
            this.toBuild = toBuild;
        }

        public B withName(String name) {
            toBuild.setName(name);
            return (B) this;
        }

        public B withParentId(UUID parentId) {
            toBuild.setParentId(parentId);
            return (B) this;
        }

        public B withId(UUID id) {
            toBuild.setId(id);
            return (B) this;
        }

        public T build() {
            return toBuild;
        }
    }
}
