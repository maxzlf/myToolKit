package com.zhulinfeng.toolkit.impl.commands.convert;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.exceptions.InvalidArgumentException;
import com.zhulinfeng.toolkit.impl.CommandOutPut;
import com.zhulinfeng.toolkit.impl.common.IpMalipulations;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class Ipv4StringValueToInt implements Command {

    public ExecuteOutput execute(ArrayList<String> args) {
        String result;

        try {
            IpMalipulations.verifyIp(args.get(0));
            result = Integer.toString((int)IpMalipulations.string2Int(args.get(0))) + "\n";
        } catch (InvalidArgumentException e) {
            result = e.getMessage();
        }

        return new CommandOutPut(result);
    }

    public String help() {
        return OutPutTable.getSummary("ipv4 string value [] to int") + "turn ipv4 string like x.x.x.x to an integer.\n";

    }
}
