package pl.wsb.programowaniejava.maciejgowin.przyklad.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InternalCache {

    private Map<String, String> cache;

    public void init() {
        cache = new HashMap<>() {{
            put("pl", "Polska");
            put("de", "Niemcy");
        }};
    }

    public void clear() {
        cache = new HashMap<>();
    }

    public void addToCache(String key, String value) {
        if (cache == null) {
            throw new RuntimeException("Cache is not initialized");
        }

        cache.put(key, value);
    }

    public String getValue(String key) {
        if (cache == null) {
            throw new RuntimeException("Cache is not initialized");
        }

        return Optional.ofNullable(cache.get(key)).orElse("NO_VALUE");
    }
}
