package io.evotor.market.api.v2.model;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {

    private List<T> items;
    private Paging paging;

}
