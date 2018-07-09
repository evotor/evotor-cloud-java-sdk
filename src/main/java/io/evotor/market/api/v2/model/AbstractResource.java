package io.evotor.market.api.v2.model;

import lombok.Data;

import java.util.Date;

@Data
public abstract class AbstractResource implements Resource {

    private Date createdAt;
    private Date updatedAt;

}
