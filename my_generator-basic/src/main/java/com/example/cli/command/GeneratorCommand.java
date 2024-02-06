package com.example.cli.command;


import cn.hutool.core.bean.BeanUtil;
import com.example.Main;
import com.example.generator.MainGenerator;
import com.example.model.MainTemplateConfig;
import freemarker.template.TemplateException;
import lombok.Data;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "generator", mixinStandardHelpOptions = true)
@Data
public class GeneratorCommand implements Callable {
    /**
     * 作者
     */
    @CommandLine.Option(names = {"-a", "--author"}, arity = "0..1", description = "作者名称", interactive = true)
    private String author;
    /**
     * 输出信息
     */
    @CommandLine.Option(names = {"-o", "--output"}, arity = "0..1", description = "输出文本", interactive = true)
    private String outputText;
    /**
     * 是否循环
     */
    @CommandLine.Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否循环", interactive = true)
    private boolean loop;

    @Override
    public Integer call() throws Exception{
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
