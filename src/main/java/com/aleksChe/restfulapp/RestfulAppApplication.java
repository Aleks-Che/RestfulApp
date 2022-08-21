package com.aleksChe.restfulapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info= @Info(
				title = "RestFulApp",
				description = "Простое Rest приложение",
				contact = @Contact(
						name = "Aleksandr Chesnokov",
						email = "dark.aleks1987@gmail.com"
				)
		)
)
@SpringBootApplication
public class RestfulAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulAppApplication.class, args);
	}

}
