package com.example.generator;


import com.example.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void doGenerate(Object model) throws TemplateException, IOException {
        //静态文件生成
        String projectPath = System.getProperty("user.dir");
        String parentFile = new File(projectPath).getParent();
        String inputPath = projectPath + File.separator + "my_generator-demo-project" +File.separator + "acm-template";
        String outputPath = projectPath;
        //复制
        //StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        //动态文件生成
        System.out.println(projectPath+"=====================");
        String dynamicInputPath = parentFile + File.separator +"my_generator-basic"+File.separator+ "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = parentFile + File.separator + "acm-template/src/com/example/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, model);
    }

//    public static void main(String[] args) throws TemplateException, IOException {
//        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
//        mainTemplateConfig.setAuthor("djc");
//        mainTemplateConfig.setLoop(false);
//        mainTemplateConfig.setOutputText("求和结果：");
//        doGenerate(mainTemplateConfig);
//    }
}
