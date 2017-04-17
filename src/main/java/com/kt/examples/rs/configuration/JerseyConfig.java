package com.kt.examples.rs.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.context.annotation.Configuration;

import com.kt.examples.rs.controller.UserController;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Configuration
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    this.registerEndpoints();
    this.configureSwagger();
  }

  private void registerEndpoints() {
    this.register(UserController.class);
    this.register(WadlResource.class);
    // http://localhost:9090/v1/application.wadl
  }

  private void configureSwagger() {
    this.register(ApiListingResource.class);
    this.register(SwaggerSerializers.class);
    BeanConfig config = new BeanConfig();
    config.setConfigId("spring-boot-jaxrs-swagger");
    config.setTitle("Spring boot jaxrs swagger integration");
    config.setVersion("v1");
    config.setBasePath("/");
    config.setResourcePackage("com.kt.examples.rs");
    config.setPrettyPrint(true);
    config.setScan(true);
    // http://localhost:9090/v1/swagger.json
  }
}
