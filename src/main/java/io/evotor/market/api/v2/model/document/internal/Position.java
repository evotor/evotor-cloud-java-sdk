package io.evotor.market.api.v2.model.document.internal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Position extends BasicPosition {

    private Integer id;
    private String uuid;
    private Collection<Object> extraKeys = Collections.emptyList();
    private Collection<Position> subPositions = Collections.emptyList();
    private Integer measurePrecision;
    private BigDecimal price;
    private BigDecimal costPrice;
    private BigDecimal resultPrice;
    private BigDecimal sum;
    private TaxValue tax;
    private BigDecimal resultSum;
    private PositionDiscount positionDiscount;
    private PositionDiscount docDistributedDiscount;
    private UUID printGroupId;
    private List<SplittedPosition> splittedPositions;

}
