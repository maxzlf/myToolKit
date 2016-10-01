package com.zhulinfeng.toolkit.api;

import java.util.ArrayList;

public class ExplainResult {
    private long commandIndex;
    private ArrayList<String> args;

    public ExplainResult(long commandIndex, ArrayList<String> args) {
        this.commandIndex = commandIndex;
        this.args = args;
    }

    public long getCommandIndex() {
        return commandIndex;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public String toString() {
        return "commondIndex : " + commandIndex + "\n"
                + "args : " + args;
    }
}
