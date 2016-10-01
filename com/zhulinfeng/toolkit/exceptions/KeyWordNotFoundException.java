package com.zhulinfeng.toolkit.exceptions;

public class KeyWordNotFoundException extends Exception {
    public KeyWordNotFoundException(String keyWord) {
        super("error : key word [" + keyWord + "] not found.\n");
    }
}
