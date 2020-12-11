package com.prokarma.apigee.caches.config;

import com.google.inject.AbstractModule;
import com.prokarma.apigee.caches.service.CacheService;
import com.prokarma.apigee.caches.service.CacheServiceImpl;

public class ApigeeCacheServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(CacheService.class).to(CacheServiceImpl.class);
  }

}
