package net.andrzejczak.hztest.api;

import lombok.RequiredArgsConstructor;
import net.andrzejczak.hztest.service.CacheService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
class Controller {
    private final CacheService cacheService;

    @GetMapping("/cache/{key}")
    String getCacheValue(@PathVariable("key") String key) {
        return cacheService.get(key);
    }

    @PostMapping("/cache")
    void addCacheValue(@RequestBody CacheRequest request) {
        cacheService.add(request.key, request.value);
    }

    @PutMapping("/cache/{key}")
    void updateCacheValue(@PathVariable("key") String key, @RequestBody String value) {
        cacheService.update(key, value);
    }

    record CacheRequest(String key, String value) {

    }
}
