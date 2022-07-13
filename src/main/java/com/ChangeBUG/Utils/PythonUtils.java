package com.ChangeBUG.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class PythonUtils {

    Logger logger = LoggerFactory.getLogger(getClass().getName());

    /**
     * 运行 Python
     * @param path 运行 路径
     * @return
     * @throws Exception
     */
    public String RunPython(String path) throws Exception {

        StringBuilder zhi = new StringBuilder();
        String line = null;
        Process proc = Runtime.getRuntime().exec("python " + path);
        BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "gbk"));
        while ((line = in.readLine()) != null) {
            zhi.append(line).append("\n");
        }
        in.close();
        proc.waitFor();

        return zhi.toString();
    }

}
