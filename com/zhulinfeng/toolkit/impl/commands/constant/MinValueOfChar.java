package com.zhulinfeng.toolkit.impl.commands.constant;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.impl.CommandOutPut;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class MinValueOfChar implements Command {

    public ExecuteOutput execute(ArrayList<String> args) {
        return new CommandOutPut(String.valueOf((int) Character.MIN_VALUE).toString() + "\n");
    }

    public String help() {
        return OutPutTable.getSummary("min value of char") + "none.\n";
    }
}
