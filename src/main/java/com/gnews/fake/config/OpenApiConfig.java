package com.gnews.fake.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI gnewsOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Fake GNews API")
                        .description("A deterministic mock implementation of the GNews API for testing purposes.")
                        .version("v4")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                        .contact(new Contact().name("GNews Mock Support").email("support@mock.gnews.io")));
    }
}
