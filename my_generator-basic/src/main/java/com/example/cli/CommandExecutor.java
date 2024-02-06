package com.example.cli;


import com.example.cli.command.ConfigCommand;
import com.example.cli.command.GeneratorCommand;
import com.example.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;


/**
 * 命令模式的调用者
 */
@Command(name= "my-generator", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new GeneratorCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        System.out.println("请输入具体指令，或者输入--help 查看帮助文档");
    }


    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
