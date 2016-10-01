package com.zhulinfeng.toolkit.impl.common;

public class StringMalipulations {
    private StringMalipulations() {
        throw new IllegalStateException();
    }

    public static String string2Hex(String str) {
        String result = "";

        for (Character c : str.toCharArray()) {
            result += char2Hex(c);
        }

        return result;
    }

    public static String string2Binary(String str) {
        String result = "";

        for (Character c : str.toCharArray()) {
            result += char2Binary(c);
        }

        return result.trim();
    }

    public static String char2Hex(char c) {
        final int mask = 0x0f;
        String result = "";

        for (int i=0; i<Character.SIZE/4; i++) {
            char tmp = HexTable.getHexByValue(c & mask).getChar();
            result = tmp + result;
            c >>>= 4;
        }

        return result;
    }

    public static String char2Binary(char c) {
        String result = "";
        final char mask = 0x01;

        for (int i=0; i<Character.SIZE/Byte.SIZE; i++) {
            for (int j=0; j<Byte.SIZE; j++) {
                char tmp = 0 == (c & mask) ? '0' : '1';
                result = tmp + result;
                c >>>= 1;
            }
            result = ' ' + result;
        }

        return result;
    }
}
