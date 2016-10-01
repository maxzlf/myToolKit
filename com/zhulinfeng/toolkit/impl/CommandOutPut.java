package com.zhulinfeng.toolkit.impl;

import com.zhulinfeng.toolkit.api.ExecuteOutput;

public class CommandOutPut implements ExecuteOutput {
    private final String output;

    public CommandOutPut(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

    public String toString() {
        return output;
    }
}
