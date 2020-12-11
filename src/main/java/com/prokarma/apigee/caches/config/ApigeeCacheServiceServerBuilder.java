package com.prokarma.apigee.caches.config;

import java.util.Arrays;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import com.google.inject.servlet.GuiceFilter;
import com.google.inject.servlet.ServletModule;
import com.squarespace.jersey2.guice.BootstrapUtils;

public class ApigeeCacheServiceServerBuilder {

  private int port = 8080;

  public ApigeeCacheServiceServerBuilder() {
    super();
  }

  public ApigeeCacheServiceServerBuilder(int port) {
    super();
    this.port = port;
  }

  public Server build() {
    Server server = new Server(port);

    ServiceLocator locator = BootstrapUtils.newServiceLocator();

    BootstrapUtils.newInjector(locator,
        Arrays.asList(new ServletModule(), new ApigeeCacheServiceModule()));
    BootstrapUtils.install(locator);

    ResourceConfig config = ResourceConfig.forApplication(new ApigeeCacheServiceConfig());

    ServletContainer servletContainer = new ServletContainer(config);
    ServletHolder sh = new ServletHolder(servletContainer);

    FilterHolder filterHolder = new FilterHolder(GuiceFilter.class);

    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    context.addFilter(filterHolder, "/*", EnumSet.allOf(DispatcherType.class));
    context.addServlet(sh, "/*");
    server.setHandler(context);

    return server;
  }

}
