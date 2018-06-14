package io.evotor.market.api.v2.builder;

import io.evotor.market.api.v2.model.Page;
import io.evotor.market.api.v2.model.document.Document;
import io.evotor.market.api.v2.model.document.DocumentType;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public interface Documents {

    StoreDocumentUntilBuilder since(long since);

    default StoreDocumentUntilBuilder all() {
        return since(0);
    }

    default StoreDocumentTypesBuilder yesterday() {
        return last(1, ChronoUnit.DAYS);
    }

    default StoreDocumentTypesBuilder lastWeek() {
        return last(1, ChronoUnit.WEEKS);
    }

    default StoreDocumentTypesBuilder last(int amount, ChronoUnit unit) {
        long now = LocalDateTime.now()
                .toEpochSecond(ZoneOffset.UTC) * 1000;

        long lastDay = LocalDateTime.now()
                .minus(unit.getDuration().multipliedBy(amount))
                .toEpochSecond(ZoneOffset.UTC) * 1000;

        return since(lastDay).until(now);
    }

    interface StoreDocumentUntilBuilder extends StoreDocumentTypesBuilder {
        StoreDocumentTypesBuilder until(long until);
    }

    interface StoreDocumentTypesBuilder extends DocumentFinalStage {
        StoreDocumentTypesBuilder type(DocumentType type);
    }

    interface DocumentFinalStage extends Iterable<Document> {
        Page<Document> fetch();
    }
}
