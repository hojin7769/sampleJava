package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("http://112.169.9.172/","https://112.169.9.172/", "http://127.0.0.1:5176","https://ljs.goodcen.com/")
			.allowedMethods("*")
			.allowCredentials(true);
	}
}
