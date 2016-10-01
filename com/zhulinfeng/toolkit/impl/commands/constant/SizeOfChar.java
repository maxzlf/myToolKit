package com.zhulinfeng.toolkit.impl.commands.constant;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.impl.CommandOutPut;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class SizeOfChar implements Command {

    public ExecuteOutput execute(ArrayList<String> args) {
        return new CommandOutPut(String.valueOf(Character.SIZE/Byte.SIZE) + "\n");
    }

    public String help() {
        return OutPutTable.getSummary("size of char") + "how many bytes of a char.\n";
    }
}
