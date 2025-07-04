//package br.com.fatec.fretenetapi.controller;
//
//import com.github.benmanes.caffeine.cache.Cache;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.caffeine.CaffeineCache;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//public class CacheController {
//    private final CacheManager cacheManager;
//
//    public CacheController(CacheManager cacheManager) {
//        this.cacheManager = cacheManager;
//    }
//
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/cache")
//    public Map<Object, Object> cache() {
//        CaffeineCache cache = (CaffeineCache) cacheManager.getCache("fretenetapi-cache");
//        if (cache == null) {
//            return Map.of();
//        }
//        Cache<Object, Object> nativeCache = cache.getNativeCache();
//        return new HashMap<>(nativeCache.asMap());
//    }
//
//}
