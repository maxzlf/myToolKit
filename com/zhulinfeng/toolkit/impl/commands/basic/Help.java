package com.zhulinfeng.toolkit.impl.commands.basic;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.impl.CommandLineFetcher;
import com.zhulinfeng.toolkit.impl.CommandOutPut;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class Help implements Command {

    public ExecuteOutput execute(ArrayList<String> args) {
        String line  = OutPutTable.getLine();
        String title = OutPutTable.getTitle("Help");
        String body = new CommandLineFetcher().getHelp();
        String split = OutPutTable.getSplit();
        String foot = "Author : Zhu linfeng\n"
                    + "Email : 1453065649@qq.com\n";
        return new CommandOutPut(line + title + body + split + foot + line);
    }

    public String help() {
        String summary = OutPutTable.getSummary("help");
        return  summary
                + "get help information of all command lines.\n"
                + OutPutTable.nChar(summary.length(), ' ')
                + "Each information is like this <usage : help information>.\n";
    }
}
