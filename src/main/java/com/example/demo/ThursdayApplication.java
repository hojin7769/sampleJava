package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ThursdayApplication {

	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ThursdayApplication.class)
		.run(args);
	}

}



//package com.example.demo;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//
//@SpringBootApplication
//public class ThursdayApplication extends SpringBootServletInitializer {
//	public static void main(String[] args){
//		SpringApplication.run(ThursdayApplication.class, args);
//	}
//	
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(ThursdayApplication.class);
//	}
//}