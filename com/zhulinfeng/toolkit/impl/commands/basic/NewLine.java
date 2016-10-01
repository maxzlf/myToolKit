package com.zhulinfeng.toolkit.impl.commands.basic;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.impl.CommandOutPut;

import java.util.ArrayList;

public class NewLine implements Command {

    public ExecuteOutput execute(ArrayList<String> args) {
        return new CommandOutPut("");
    }


    public String help() {
        return "";
    }
}
