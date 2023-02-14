package com.example.demo.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class testApi {

	private RunShellScript shellScript;
	@GetMapping("/hello")
	public String hello(){
		return "hello Tuesday Spring API 응답쏘리 낫 쏘리";
	};


	@GetMapping("test")
	public String test() {
		return shellScript.runShell();
	}
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/profile")
	public String getProfile() {
		return Arrays.stream(environment.getActiveProfiles())
				.findFirst()
				.orElse("");
	}
}
