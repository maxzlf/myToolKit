package com.zhulinfeng.toolkit.impl.commands.convert;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.exceptions.InvalidArgumentException;
import com.zhulinfeng.toolkit.impl.CommandOutPut;
import com.zhulinfeng.toolkit.impl.common.NumberMalipulations;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class IntToBinary implements Command {

    public ExecuteOutput execute(ArrayList<String> args) {
        String result;

        try {
            result = Long.toBinaryString(NumberMalipulations.turnStrToLong(args.get(0))) + "\n";
        } catch (InvalidArgumentException e) {
            result = e.getMessage();
        }

        return new CommandOutPut(result);
    }

    public String help() {
        return OutPutTable.getSummary("int value [] to binary") + "none.\n";
    }
}
