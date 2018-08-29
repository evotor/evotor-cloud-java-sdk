package io.evotor.market.api.v2.model;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class BulkTask<T extends AbstractResource> {

    private UUID id;
    private TaskStatus status;
    private Date modifiedAt;
    private List<T> details;

}
