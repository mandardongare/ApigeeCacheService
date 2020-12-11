package com.prokarma.apigee.caches.controller;

import org.eclipse.jetty.server.Server;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import com.prokarma.apigee.caches.config.ApigeeCacheServiceServerBuilder;

public class ServerExtension implements BeforeAllCallback, AfterAllCallback {

  private Server server = new Server(9090);

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    try {
      server.stop();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      server.destroy();
    }
  }

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    server = new ApigeeCacheServiceServerBuilder().build();
    server.start();
  }

  public String getBaseUri() {
    return server.getURI().toString();
  }


}
