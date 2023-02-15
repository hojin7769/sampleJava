package com.example.demo.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.demo.shell.CommandLineExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

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
	@PostMapping("/test2")
	public Map test2(@RequestBody(required = false) Map<String, Object> param) {



		List<String> list = param.entrySet().stream()
				.map(item ->  item.getValue().toString())
				.collect(Collectors.toList());

		String value = "";
		for (String a:
			list ) {
			value = value + " " + a;
		}


		String cmds = "sh /var/local/sh/svnpull.sh";
		String[] callCmd = {"/bin/bash", "-c", cmds + value};
//		String[] callCmd = {cmds,params};
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
