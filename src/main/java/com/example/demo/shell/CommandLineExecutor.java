package com.example.demo.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommandLineExecutor {

    public static String execute(String cmd) {
        Process process = null;
        Runtime runtime = Runtime.getRuntime();

        StringBuffer successOutput = new StringBuffer();
        StringBuffer errorOutput = new StringBuffer();
        BufferedReader successBufferReader = null;
        BufferedReader errorBufferReader = null;

        String msg = null;

        List<String> cmdList = new ArrayList<>();
        cmdList.add("/bin/bash");
        cmdList.add("-c");

//        if (System.getProperty("os.name").indexOf("Windows") > -1) {
//            cmdList.add("cmd");
//            cmdList.add("/c");
//        } else {
//            cmdList.add("/bin/sh");
//            cmdList.add("-c");
//        }

        cmdList.add(cmd);
        cmdList.add("TEST");
        String[] array = cmdList.toArray(new String[cmdList.size()]);
        try {
            process = runtime.exec(array);

            successBufferReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "EUC-KR"));

            while ((msg = successBufferReader.readLine()) != null) {
                successOutput.append(msg + System.getProperty("line.separator"));
            }

            // shell 실행시 에러가 발생했을 경우
            errorBufferReader = new BufferedReader(new InputStreamReader(process.getErrorStream(), "EUC-KR"));
            while ((msg = errorBufferReader.readLine()) != null) {
                errorOutput.append(msg + System.getProperty("line.separator"));
            }

            // 프로세스의 수행이 끝날때까지 대기
            process.waitFor();

            // shell 실행이 정상 종료되었을 경우
            if (process.exitValue() == 0) {
                System.out.println("성공");
                System.out.println(successOutput.toString());
                return successOutput.toString();
            } else {
                // shell 실행이 비정상 종료되었을 경우
                System.out.println("비정상 종료");
                System.out.println(successOutput.toString());
                return successOutput.toString();
            }

//             shell 실행시 에러가 발생
//            if (CommonUtil.isEmpty(errorOutput.toString())) {
//                // shell 실행이 비정상 종료되었을 경우
//                System.out.println("오류");
//                System.out.println(successOutput.toString());
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                process.destroy();
                if (successBufferReader != null) successBufferReader.close();
                if (errorBufferReader != null) errorBufferReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return msg;
    }

}
