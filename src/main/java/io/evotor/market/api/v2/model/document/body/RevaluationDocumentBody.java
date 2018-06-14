package io.evotor.market.api.v2.model.document.body;

import io.evotor.market.api.v2.model.document.DocumentBody;
import lombok.Data;

import java.math.BigDecimal;
import java.util.*;

@Data
public class RevaluationDocumentBody implements DocumentBody {

    private UUID baseDocumentId;
    private Integer baseDocumentNumber;
    private List<Position> positions = new ArrayList<>();

    @Data
    public static class Position {
        private String productId;
        private String code;
        private Price price;
        private Collection<Object> extraKeys = Collections.emptyList();
    }

    @Data
    public static class Price {

        BigDecimal before;
        BigDecimal after;
        BigDecimal accept;

    }
}
