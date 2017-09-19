package fr.istic.m2.jaxrs;

import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import java.util.logging.Logger;

public class RestServer {
  private static final Logger logger = Logger.getLogger(RestServer.class.getName());

  public static void main(String[] args) {
    UndertowJaxrsServer ut = new UndertowJaxrsServer();
    MainApplication app = new MainApplication();

    ut.deploy(app);
    ut.start(Undertow.builder().addHttpListener(8080, "localhost"));

    logger.info("JAX-RS based micro-service running");
  }
}
