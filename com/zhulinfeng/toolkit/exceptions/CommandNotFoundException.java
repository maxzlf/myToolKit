package com.zhulinfeng.toolkit.exceptions;

public class CommandNotFoundException extends Exception {
    public CommandNotFoundException() {
        super("error : command line not found.\n");
    }
}
