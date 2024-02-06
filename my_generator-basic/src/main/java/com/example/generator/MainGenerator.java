package com.example.generator;


import com.example.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        //静态文件生成
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + File.separator + "my_generator-demo-project" +File.separator + "acm-template";
        String outputPath = projectPath;
        //复制
        StaticGenerator.copyFileByHutool(inputPath, outputPath);

        //动态文件生成

        System.out.println(projectPath);
        String dynamicInputPath = projectPath + File.separator +"my_generator-basic"+File.separator+ "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/example/acm/MainTemplate.java";

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("djc");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果：");
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);
    }
}
