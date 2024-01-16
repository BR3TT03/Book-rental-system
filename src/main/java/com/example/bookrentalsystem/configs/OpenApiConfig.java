package com.example.bookrentalsystem.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Book Rental System API",
                version = "v1",
                description = "This app provides REST APIs for book rental system"
        ),
        servers = {
                @Server(
                        url="https://book-rental-aew6.onrender.com",
                        description = "Production Server"
                )
        }
)

@Configuration
public class  OpenApiConfig {
}
