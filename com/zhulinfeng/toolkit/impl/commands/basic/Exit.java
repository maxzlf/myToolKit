package com.zhulinfeng.toolkit.impl.commands.basic;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.exceptions.ExitException;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class Exit implements Command {

    public ExecuteOutput execute(ArrayList<String> args)  {
        throw new ExitException("common exit");
    }

    public String help() {
        return OutPutTable.getSummary("exit") + "exit toolkit.\n";
    }
}
