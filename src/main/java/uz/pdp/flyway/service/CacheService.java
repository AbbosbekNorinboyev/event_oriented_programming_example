package uz.pdp.flyway.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheService {
    private final ConcurrentHashMap<Object, Map<Object, Object>> cache = new ConcurrentHashMap<>();

    public void put(Map<Object, Object> model) {
        cache.putIfAbsent(model.get("userId"), model);
    }

    public Map<Object, Object> get(Object key) {
        return cache.get(key);
    }

    public ConcurrentHashMap<Object, Map<Object, Object>> getCache() {
        return cache;
    }
}
