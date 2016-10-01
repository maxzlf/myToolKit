package com.zhulinfeng.toolkit.impl;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.CommandKeyWords;
import com.zhulinfeng.toolkit.api.ExecuteOutput;

import java.util.ArrayList;
import java.util.Collections;

public class CommandLine implements Command {
    private long commandIndex = -1;
    private Class commandClass;
    private ArrayList<CommandKeyWords> commandKeyWords = new ArrayList<>();

    public CommandLine(CommandKeyWords[] keyWords, Class commandClass) {
        this.commandClass = commandClass;

        if (null != keyWords) {
            Collections.addAll(commandKeyWords, keyWords);
        }
    }

    public ExecuteOutput execute(ArrayList<String> args) {
        Command command = null;
        ExecuteOutput output;

        try {
            command = (Command) commandClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        if (null == command) {
            output = new CommandOutPut("error : command not loaded.\n");
        } else {
            output = command.execute(args);
        }

        return output;
    }

    public String help() {
        try {
            Command command = (Command) commandClass.newInstance();
            return command.help();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public long getCommandIndex() {
        if (commandIndex < 0) {
            long tmp = 0;
            for (CommandKeyWords keyWord : commandKeyWords) {
                tmp <<= Byte.SIZE;
                tmp += keyWord.getCommandIndex();
            }
            commandIndex = tmp;
        }

        return commandIndex;
    }
}
