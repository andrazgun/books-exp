package com.books.session;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class ScenarioSession {
    private ThreadLocal<Map<String, Object>> CONTAINER = ThreadLocal.withInitial(HashMap::new);

    public <T> void put(String key, T value) {
        threadLocalMap().put(key, value);
    }

    public <T> T get(String key, Class<T> type) {
        return type.cast(threadLocalMap().get(key));
    }

    public <T> T getAs(String key, Class<T> type) {
        Object value = threadLocalMap().get(key);
        try {
            return type.cast(value);
        } catch (ClassCastException e) {
            throw new RuntimeException(format("ScenarioSession object with key [%s] cannot be cast to desired type. Value:[%s]", key, value), e);
        }
    }
    private Map<String, Object> threadLocalMap() {
        return CONTAINER.get();
    }

    public String getAsString(String key) {
        return getAs(key, String.class);
    }

    public double getAsDouble(String key) {
        return Double.parseDouble(getAsString(key));
    }
}
