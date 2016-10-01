package com.zhulinfeng.toolkit.impl.commands.basic;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.impl.CommandOutPut;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class WelCome implements Command {
    @Override
    public ExecuteOutput execute(ArrayList<String> args) {
        String result = OutPutTable.getLine();
        result += "Welcome!\n";
        result += "I'm a tool kit for developer.\n";
        result += "Any problem please enter 'help' for manual.\n";
        result += OutPutTable.getLine();

        return new CommandOutPut(result);
    }

    @Override
    public String help() {
        return "";
    }
}
