package io.evotor.market.api.v2.model.product;

import io.evotor.market.api.v2.model.TaskStatus;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ProductBulkTask {

    private UUID id;
    private TaskStatus status;
    private Date modifiedAt;

}
