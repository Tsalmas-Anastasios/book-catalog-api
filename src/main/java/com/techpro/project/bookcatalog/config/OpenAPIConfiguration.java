package com.techpro.project.bookcatalog.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

/**
 * This class is responsible for configuring the OpenAPI documentation for the
 * Book Catalog-Management System API.
 * It defines the API title, version, description, contact information, and
 * server URL.
 */
@Configuration
public class OpenAPIConfiguration {

  @Bean
  public OpenAPI defineOpenApi() {
    Server server = new Server();
    server.setUrl("http://localhost:8080");
    server.setDescription("Development");

    Contact myContact = new Contact();
    myContact.setName("Vasileios Vasileiadis");
    myContact.setEmail("vasileios.vasileiadis@techproacademy.gr");

    Info information = new Info()
        .title("Book Catalog-Management System API")
        .version("1.0")
        .description("This API exposes endpoints to manage books.")
        .contact(myContact);
    return new OpenAPI().info(information).servers(List.of(server));
  }
}
