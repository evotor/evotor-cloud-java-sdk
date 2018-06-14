package io.evotor.market.api.v2.impl;

import java.util.function.Function;

class Impl {

    private final Function<Class, Object> apiProvider;

    Impl(Function<Class, Object> apiProvider) {
        this.apiProvider = apiProvider;
    }

    @SuppressWarnings("unchecked")
    protected  <T> T get(Class<T> target) {
        return (T) apiProvider.apply(target);
    }
}
