package com.zhulinfeng.toolkit.impl.commands.constant;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.impl.CommandOutPut;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class InfoOfAllBasicType implements Command {
    public ExecuteOutput execute(ArrayList<String> args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new InfoOfChar().execute(new ArrayList<String>()).getOutput());
        stringBuilder.append(new InfoOfByte().execute(new ArrayList<String>()).getOutput());
        stringBuilder.append(new InfoOfShort().execute(new ArrayList<String>()).getOutput());
        stringBuilder.append(new InfoOfInt().execute(new ArrayList<String>()).getOutput());
        stringBuilder.append(new InfoOfLong().execute(new ArrayList<String>()).getOutput());
        stringBuilder.append(new InfoOfFloat().execute(new ArrayList<String>()).getOutput());
        stringBuilder.append(new InfoOfDouble().execute(new ArrayList<String>()).getOutput());

        return new CommandOutPut(stringBuilder.toString());
    }

    public String help() {
        return OutPutTable.getSummary("info of all basic type") + "information of all java basic types.\n";
    }
}
