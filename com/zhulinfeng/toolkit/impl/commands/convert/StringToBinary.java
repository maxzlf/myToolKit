package com.zhulinfeng.toolkit.impl.commands.convert;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.impl.CommandOutPut;
import com.zhulinfeng.toolkit.impl.common.StringMalipulations;

import java.util.ArrayList;

public class StringToBinary implements Command {

    public ExecuteOutput execute(ArrayList<String> args) {
        return new CommandOutPut(StringMalipulations.string2Binary(args.get(0)) + '\n');
    }

    public String help() {
        return "string value [] to binary : none.\n";
    }
}
