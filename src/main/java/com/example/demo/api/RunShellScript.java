package com.example.demo.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunShellScript {

    public String runShell(){
        try{
            // Run script
            Process process = Runtime.getRuntime().exec("/tmp/shellTest/myscript.sh");

            // Read output
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while((line = reader.readLine()) != null){
                output.append(line);
            }
         return output.toString();

        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}