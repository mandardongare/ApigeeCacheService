
package com.prokarma.apigee.caches;

import org.eclipse.jetty.server.Server;
import com.prokarma.apigee.caches.config.ApigeeCacheServiceServerBuilder;

public class ApigeeCacheServiceApplication {

  public static void main(String[] args) throws Exception {
    Server server = new ApigeeCacheServiceServerBuilder().build();

    try {
      server.start();
      server.join();
    } finally {
      server.destroy();
    }

  }

}

