package com.zhulinfeng.toolkit.impl.commands.convert;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.exceptions.InvalidArgumentException;
import com.zhulinfeng.toolkit.impl.CommandOutPut;
import com.zhulinfeng.toolkit.impl.common.NumberMalipulations;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class IntToAsciiChar implements Command {

    public ExecuteOutput execute(ArrayList<String> args) {
        String result;

        try {
            long number = NumberMalipulations.turnStrToLong(args.get(0));
            if (number <0 || number > Byte.MAX_VALUE) {
                throw new InvalidArgumentException(args.get(0));
            }
            result = (char)number + "\n";
        } catch (InvalidArgumentException e) {
            result = e.getMessage();
        }

        return new CommandOutPut(result);
    }


    public String help() {
        return OutPutTable.getSummary("int value [] to ascii char") + "none.\n";
    }
}
