package com.zhulinfeng.toolkit.impl.commands.convert;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.exceptions.InvalidArgumentException;
import com.zhulinfeng.toolkit.impl.CommandOutPut;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class ValueOfAsciiChar implements Command {

    public ExecuteOutput execute(ArrayList<String> args) {
        String result;
        String arg = args.get(0);

        try {
            if (arg.length() > 1) {
                throw new InvalidArgumentException(arg);
            }
            int value = arg.charAt(0);
            if (value < 0 || value > Byte.MAX_VALUE) {
                throw new InvalidArgumentException(arg);
            }

            String octal = "octal : " + Integer.toOctalString(value) + '\t';
            String decimal = "decimal : " + Integer.toString(value) + '\t';
            String hexadecimal = "hexadecimal : " + Integer.toHexString(value);
            result = octal + decimal + hexadecimal + '\n';
        } catch (InvalidArgumentException e) {
            result = e.getMessage();
        }

        return new CommandOutPut(result);
    }


    public String help() {
        return OutPutTable.getSummary("value of ascii char []") + "none.\n";
    }
}
