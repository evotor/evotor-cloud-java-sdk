package io.evotor.market.api.v2.model.document.body;

import io.evotor.market.api.v2.model.document.DocumentBody;
import io.evotor.market.api.v2.model.document.internal.Position;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BasePositionBody implements DocumentBody {

    private List<Position> positions = new ArrayList<>();

}
