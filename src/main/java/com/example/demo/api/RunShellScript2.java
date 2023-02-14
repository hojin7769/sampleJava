package com.example.demo.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunShellScript2 {


    public void run(){

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("/tmp/shellTest/myscript.sh");



        try{
            // Run script
            Process process = processBuilder.start();

            // Read output
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }

            System.out.println(output.toString());

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
