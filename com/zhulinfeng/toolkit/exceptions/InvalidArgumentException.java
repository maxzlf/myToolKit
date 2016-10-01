package com.zhulinfeng.toolkit.exceptions;

public class InvalidArgumentException extends Exception {
    public InvalidArgumentException(String arg) {
        super("error : argument [" + arg + "] is invalid.\n");
    }
}
