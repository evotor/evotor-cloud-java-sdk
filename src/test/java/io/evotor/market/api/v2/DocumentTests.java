package io.evotor.market.api.v2;

import io.evotor.market.api.v2.model.document.Document;
import org.junit.Test;

import java.util.Iterator;

import static io.evotor.market.api.v2.ApiHolder.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class DocumentTests {

    @Test
    public void store_documents_iterator_should_be_created() {
        Iterator<Document> iterator = api.stores()
                .select(STORE)
                .documents()
                .all()
                .iterator();

        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void should_fetch_single_document_by_id() {
        Document document = api.stores()
                .select(STORE)
                .documents()
                .select(DEFAULT)
                .fetch();

        assertNotNull(document);
    }
}