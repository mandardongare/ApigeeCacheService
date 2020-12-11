package com.prokarma.apigee.caches.config;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import com.prokarma.apigee.caches.controller.CacheController;
import com.prokarma.apigee.caches.exception.CacheOperationFailureExceptionHandler;

@ApplicationPath("/")
public class ApigeeCacheServiceConfig extends ResourceConfig {

  public ApigeeCacheServiceConfig() {
    packages(CacheController.class.getPackage().getName(),
        CacheOperationFailureExceptionHandler.class.getPackage().getName());
  }

}
