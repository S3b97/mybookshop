package com.sanvalero.mybookshop.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookshopConfig {

@Bean
public OpenAPI customOpenAPI(){

    return new OpenAPI()
            .components(new Components())
            .info(new Info().title("mybookshop API")
            .description("Ejemplo API")
            .contact(new Contact()
            .name("Sebastian Camino")
            .email("SCamino@outlook.com")
            .url("https://www.casadellibro.com"))
            .version("1.0"));


}

}
