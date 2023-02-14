package com.example.demo.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShRunnerTest {

    ShRunner shRunner = new ShRunner();

    @Test
    public void name() throws IOException, InterruptedException {
        String cmds = "sh /Users/Kyeongrok/hello.sh";
        String[] callCmd = {"/bin/bash", "-c", cmds};
        Map map = shRunner.execCommand(callCmd);

        System.out.println(map);
    }

}