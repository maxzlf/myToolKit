package com.zhulinfeng.toolkit.impl.commands.convert;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.exceptions.InvalidArgumentException;
import com.zhulinfeng.toolkit.impl.CommandOutPut;
import com.zhulinfeng.toolkit.impl.common.IpMalipulations;
import com.zhulinfeng.toolkit.impl.common.NumberMalipulations;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class Ipv4IntValueToString implements Command {

    public ExecuteOutput execute(ArrayList<String> args) {
        String result;
        int ipInt;

        try {
            ipInt = NumberMalipulations.turnStrToInt(args.get(0));
            result = IpMalipulations.intToIpAddr(ipInt) + "\n";
        } catch (InvalidArgumentException e) {
            result = e.getMessage();
        }

        return new CommandOutPut(result);
    }


    public String help() {
        return OutPutTable.getSummary("ipv4 int value [] to string") + "turn integer number to string like x.x.x.x.\n";
    }
}