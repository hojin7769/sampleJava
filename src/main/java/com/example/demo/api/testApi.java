package com.example.demo.api;

import java.util.Arrays;
import java.util.Map;

import com.example.demo.shell.CommandLineExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class testApi {

	private RunShellScript shellScript = new RunShellScript();
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
		String cmds = "sh /var/local/sh/svnpull.sh";
		String params = "TEST";
//		String[] callCmd = {"/bin/bash", "-c", cmds,params};
		String[] callCmd = {cmds,params};
		Map map = shRunner.execCommand(callCmd);

		System.out.println(map);
		return map;
	}

	@GetMapping("test3")
	public String test3() {
		String cmds = "sh /var/local/sh/svnpull.sh";
		CommandLineExecutor.execute(cmds);
		return "";
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
