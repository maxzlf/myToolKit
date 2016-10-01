package com.zhulinfeng.toolkit.exceptions;

public class ExitException extends IllegalStateException {
    public ExitException(String arg) {
        super(arg + '\n');
    }
}
