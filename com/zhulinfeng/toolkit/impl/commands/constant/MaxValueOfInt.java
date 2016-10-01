package com.zhulinfeng.toolkit.impl.commands.constant;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.impl.CommandOutPut;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class MaxValueOfInt implements Command {

    public ExecuteOutput execute(ArrayList<String> args) {
        return new CommandOutPut(Integer.toString(Integer.MAX_VALUE) + "\n");
    }

    public String help() {
        return OutPutTable.getSummary("max value of int") + "none.\n";
    }
}
