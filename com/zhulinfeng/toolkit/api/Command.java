package com.zhulinfeng.toolkit.api;

import java.util.ArrayList;

public interface Command {
    ExecuteOutput execute(ArrayList<String> args);

    String help();
}

