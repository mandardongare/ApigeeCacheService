package com.prokarma.apigee.caches.service;

public interface CacheService {
  String getCacheNames(String authorization, String org, String env);

  String createCache(String json, String authorization, String org, String env);

  String updateCache(String json, String authorization, String org, String env, String cacheId);

  String deleteCache(String authorization, String org, String env, String cacheId);
}
