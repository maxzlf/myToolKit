package com.zhulinfeng.toolkit.api;

import com.zhulinfeng.toolkit.exceptions.CommandNotFoundException;

public interface FetchCommand {
    Command getCommand(long commandIndex) throws CommandNotFoundException;
    String getHelp();
}
