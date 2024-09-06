package com.productmicroservice.product.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    public OpenAPI api(){
        return new OpenAPI().info(new Info()
                .title("MongoDB Learning API")
                .version("1.0")
                .description("API documentation for MongoDB Spring Boot application"));

    }
}
