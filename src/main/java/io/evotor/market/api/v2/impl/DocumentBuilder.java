package io.evotor.market.api.v2.impl;

import io.evotor.market.api.v2.DocumentsApi;
import io.evotor.market.api.v2.builder.Documents;
import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.document.Document;
import io.evotor.market.api.v2.model.document.DocumentType;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;

class DocumentBuilder implements Documents, Documents.StoreDocumentTypesBuilder, Documents.StoreDocumentUntilBuilder, Documents.DocumentFinalStage {

    private final DocumentsApi api;
    private String store;
    private String device;
    private Long since = 0L;
    private Long until;
    private Set<String> types;

    DocumentBuilder(DocumentsApi api, String store, String device) {
        this.api = api;
        this.store = store;
        this.device = device;
    }

    static DocumentBuilder withStore(DocumentsApi api, String store) {
        return new DocumentBuilder(api, store, null);
    }

    @Override
    public Documents.StoreDocumentTypesBuilder until(long until) {
        this.until = until;
        return this;
    }

    @Override
    public Documents.StoreDocumentTypesBuilder type(DocumentType type) {
        if (this.types == null) {
            this.types = new HashSet<>();
        }

        this.types.add(type.name());
        return this;
    }

    @Override
    public Page<Document> fetch() {
        return device != null ?
                api.getDocumentsByDevice(store, device, since, until, types) :
                api.getDocuments(store, since, until, types);
    }

    @Override
    public Iterator<Document> iterator() {
        Function<String, Page<Document>> provider = device != null ?
                (nextCursor) -> (nextCursor == null ?
                        api.getDocumentsByDevice(store, device, since, until, types) :
                        api.getDocumentsByDevice(store, device, nextCursor)) :
                (nextCursor) -> (nextCursor == null ?
                        api.getDocuments(store, since, until, types) :
                        api.getDocuments(store, nextCursor));

        return new PageableIterator<>(provider);
    }

    @Override
    public StoreDocumentUntilBuilder since(long since) {
        this.since = since;
        return this;
    }

    @Override
    public DocumentInstance select(UUID document) {
        return () -> api.getSingleDocument(store, document.toString());
    }
}
