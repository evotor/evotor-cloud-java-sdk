package io.evotor.market.api.v2.impl;

import io.evotor.market.api.v2.model.Page;

import java.util.Collections;
import java.util.Iterator;
import java.util.function.Function;

class PageableIterator<T> implements Iterator<T> {

    private String nextCursor;
    private boolean finished;
    private Iterator<T> internalIterator;
    private Function<String, Page<T>> provider;

    public PageableIterator(Function<String, Page<T>> provider) {
        this.provider = provider;
    }

    @Override
    public boolean hasNext() {
        if (internalIterator == null || !internalIterator.hasNext()) {
            fetchNextPage();
        }

        return internalIterator.hasNext();
    }

    @Override
    public T next() {
        return internalIterator.next();
    }

    private void fetchNextPage() {
        if (finished) {
            this.internalIterator = Collections.emptyIterator();
        } else {
            Page<T> page = provider.apply(nextCursor);
            this.internalIterator = page.getItems().iterator();
            this.nextCursor = page.getPaging().getNextCursor();
            this.finished = nextCursor == null;
        }
    }
}
