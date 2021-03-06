package io.evotor.market.api.v2.model.document;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.evotor.market.api.v2.model.GUID;
import io.evotor.market.api.v2.model.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document implements Resource {

    private String type;
    private UUID id;
    private Map<UUID, Map<String, Object>> extras;
    private Long number;
    private Date closeDate;
    private int timeZoneOffset;
    private UUID sessionId;
    private int sessionNumber;
    private String closeUserId;
    private GUID deviceId;
    private GUID storeId;
    private String userId;
    private String version;

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
            property = "type",
            visible = true
    )
    private DocumentBody body;

    @Override
    public Date getCreatedAt() {
        return closeDate;
    }

    @Override
    public Date getUpdatedAt() {
        return closeDate;
    }
}
