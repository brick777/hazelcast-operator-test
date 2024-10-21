package net.andrzejczak.hztest.service;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    public static final String CACHE_MAP = "cache-test";
    private final IMap<String, String> map;

    public CacheService(HazelcastInstance myHazelcastInstance) {
        this.map = myHazelcastInstance.getMap(CACHE_MAP);
    }

    public void add(String key, String value) {
        this.map.putIfAbsent(key, value);
    }

    public void update(String key, String value) {
        this.map.put(key, value);
    }

    public String get(String key) {
        return map.get(key);
    }
}
