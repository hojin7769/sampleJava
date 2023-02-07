package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ThursdayApplication {

	public static final String APPLICATION_LOCATIONS = "spring.config.location="
			+ "classpath:application.yml,"
//			+ "C:\\GoodCen\\Edu\\workspace\\Thursday\\real-application.yml";
			+ "/home/huiwon/java/app/config/real-application.yml";
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ThursdayApplication.class)
		.properties(APPLICATION_LOCATIONS)
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