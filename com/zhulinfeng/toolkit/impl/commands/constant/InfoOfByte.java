package com.zhulinfeng.toolkit.impl.commands.constant;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.impl.CommandOutPut;
import com.zhulinfeng.toolkit.impl.common.OutPutTable;

import java.util.ArrayList;

public class InfoOfByte implements Command {
    public ExecuteOutput execute(ArrayList<String> args) {
        final int LENGTH = OutPutTable.SMALL_SUMMARY_LENGTH;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OutPutTable.getLine());
        stringBuilder.append(OutPutTable.getTitle("Information of byte"));
        stringBuilder.append(OutPutTable.getSummary("size", LENGTH) + new SizeOfByte().execute(new ArrayList<String>()).getOutput());
        stringBuilder.append(OutPutTable.getSummary("min value", LENGTH) + new MinValueOfByte().execute(new ArrayList<String>()).getOutput());
        stringBuilder.append(OutPutTable.getSummary("max value", LENGTH) + new MaxValueOfByte().execute(new ArrayList<String>()).getOutput());
        stringBuilder.append(OutPutTable.getLine());

        return new CommandOutPut(stringBuilder.toString());
    }

    public String help() {
        return OutPutTable.getSummary("info of byte") + "all information of byte.\n";
    }
}
