package io.evotor.market.api.v2;

import feign.Param;
import feign.RequestLine;
import io.evotor.market.api.v2.model.GUID;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.document.Document;

import java.util.Collection;

@Scope("document:read")
public interface DocumentsApi {

    @RequestLine("GET /stores/{store_id}/documents?since={since}&types={types}&until={until}")
    Page<Document> getDocuments(@Param("store_id") GUID store,
                                @Param("since") long since,
                                @Param("until") Long until,
                                @Param(value = "types") Collection<String> types);

    @RequestLine("GET /stores/{store_id}/documents?cursor={cursor}")
    Page<Document> getDocuments(@Param("store_id") GUID store,
                                @Param("cursor") String cursor);

    @RequestLine("GET /stores/{store_id}/devices/{device_id}/documents?since={since}&until={until}&types={types}")
    Page<Document> getDocumentsByDevice(@Param("store_id") GUID store,
                                        @Param("device_id") GUID device,
                                        @Param("since") long since,
                                        @Param("until") Long until,
                                        @Param(value = "types") Collection<String> types);

    @RequestLine("GET /stores/{store_id}/devices/{device_id}/documents?cursor={cursor}")
    Page<Document> getDocumentsByDevice(@Param("store_id") GUID store,
                                        @Param("device_id") GUID device,
                                        @Param("cursor") String cursor);

    @RequestLine("GET /stores/{store_id}/documents/{document_id}")
    Document getSingleDocument(
            @Param("store_id") GUID store,
            @Param("document_id") String documentId
    );

    @RequestLine("GET /stores/{store_id}/devices/{device_id}/documents/{document_id}")
    Document getSingleDocument(
            @Param("store_id") GUID store,
            @Param("device_id") GUID device,
            @Param("document_id") String documentId
    );
}
