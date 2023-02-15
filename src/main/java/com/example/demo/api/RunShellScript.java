package com.example.demo.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunShellScript {

    public String runShell(){
        try{
            String pram = "TEST ";
            String[] command = new String[] {"/bash/bin","-c","sh /var/local/sh/svnpull.sh" , pram};
            // Run script
            Process process = Runtime.getRuntime().exec(command);

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
