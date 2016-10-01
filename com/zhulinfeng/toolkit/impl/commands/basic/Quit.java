package com.zhulinfeng.toolkit.impl.commands.basic;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.exceptions.ExitException;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class Quit implements Command {

    public ExecuteOutput execute(ArrayList<String> args) {
        throw new ExitException("quit");
    }


    public String help() {
        return OutPutTable.getSummary("quit") + "quit toolkit.\n";
    }
}
