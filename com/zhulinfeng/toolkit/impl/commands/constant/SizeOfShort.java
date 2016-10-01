package com.zhulinfeng.toolkit.impl.commands.constant;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.impl.CommandOutPut;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class SizeOfShort implements Command {

    public ExecuteOutput execute(ArrayList<String> args) {
        return new CommandOutPut(String.valueOf(Short.SIZE/Byte.SIZE) + "\n");
    }

    public String help() {
        return OutPutTable.getSummary("size of short") + "how many bytes of a short.\n";
    }
}
