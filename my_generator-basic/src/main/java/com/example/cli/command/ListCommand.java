package com.example.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.util.List;
import java.io.File;

@CommandLine.Command(name = "List", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{


    @Override
    public void run() {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        String inputPath = new File(parentFile, "my_generator-demo-project/acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
