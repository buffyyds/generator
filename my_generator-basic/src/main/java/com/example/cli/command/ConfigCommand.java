package com.example.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.example.model.MainTemplateConfig;
import picocli.CommandLine;

import java.lang.reflect.Field;

/**
 * 利用反射动态的获得配置信息
 */

@CommandLine.Command(name = "config", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {


    @Override
    public void run() {
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段类型:"+field.getType());
            System.out.println("字段名称:"+field.getName());
        }
    }
}
