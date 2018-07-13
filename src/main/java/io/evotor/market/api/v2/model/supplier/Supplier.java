package io.evotor.market.api.v2.model.supplier;

import io.evotor.market.api.v2.model.AbstractResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class Supplier extends AbstractResource {

    @NotNull
    private UUID id;

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Supplier toBuild;

        Builder() {
            this.toBuild = new Supplier();
        }

        public Builder withId(UUID id) {
            this.toBuild.setId(id);
            return this;
        }

        public Builder withName(String name) {
            this.toBuild.setName(name);
            return this;
        }

        public Supplier build() {
            return toBuild;
        }
    }
}
