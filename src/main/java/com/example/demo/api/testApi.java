package com.example.demo.api;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class testApi {

	private RunShellScript shellScript;
	private RunShellScript2 runShellScript2;
	ShRunner shRunner = new ShRunner();
	@GetMapping("/hello")
	public String hello(){
		return "hello Tuesday Spring API 토요일이 나는 좋아 왜 안변해?";
	};


	@GetMapping("test")
	public String test() {
		return shellScript.runShell();
	}
	@GetMapping("test2")
	public Map test2() {
		String cmds = "sh /tmp/shellTest/myscript.sh";
		String[] callCmd = {"/bin/bash", "-c", cmds};
		Map map = shRunner.execCommand(callCmd);

		System.out.println(map);
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
