package com.bancob.location.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LocationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationApiApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/location/create")
				.allowedOrigins("http://localhost:8080","http://localhost:4200");
				registry.addMapping("/location/create/")
				.allowedOrigins("http://localhost:8080","http://localhost:4200");
				registry.addMapping("/location/all")
				.allowedOrigins("http://localhost:8080","http://localhost:4200");
				registry.addMapping("/location/")
				.allowedOrigins("http://localhost:8080","http://localhost:4200");
				registry.addMapping("/location")
				.allowedOrigins("http://localhost:8080","http://localhost:4200");
				registry.addMapping("/location/get")
				.allowedOrigins("http://localhost:8080","http://localhost:4200");
				registry.addMapping("/location/get/{id}")
				.allowedOrigins("http://localhost:8080","http://localhost:4200");
			}
		};
	}

}
