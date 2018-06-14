package io.evotor.market.api.v2.impl;

import io.evotor.market.api.v2.builder.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class ApiImpl implements Api {

    private final Map<Class, Object> apis;
    private final Function<Class, Object> apiProvider;

    public ApiImpl(Function<Class, Object> apiProvider) {
        this.apiProvider = apiProvider;
        this.apis = new ConcurrentHashMap<>();
    }

    @SuppressWarnings("unchecked")
    private <T> T get(Class<T> target) {
        return (T) apis.computeIfAbsent(target, apiProvider);
    }

    @Override
    public Stores stores() {
        return new StoresImpl(this::get);
    }

    @Override
    public Employees employees() {
        return new EmployeeImpl(this::get, null);
    }

    @Override
    public Devices devices() {
        return new DevicesImpl(this::get, null);
    }

    @Override
    public Suppliers suppliers() {
        return new SuppliersImpl(this::get);
    }
}
