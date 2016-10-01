package com.zhulinfeng.toolkit.impl.common;

import java.util.HashMap;

public class HexTable {
    private static HashMap<Integer, Hex> hexMapIntIndex = new HashMap<>();
    private static HashMap<Character, Hex> hexMapCharIndex = new HashMap<>();

    static {
        for (Hex hex : Hex.values()) {
            hexMapIntIndex.put(hex.getValue(), hex);
            hexMapCharIndex.put(hex.getChar(), hex);
        }
    }

    public static Hex getHexByValue(int hexValue) {
        Hex hex = hexMapIntIndex.get(hexValue);
        if (null == hex) {
            throw new IllegalStateException("hexadecimal value overflow.\n");
        }
        return hex;
    }

    public static Hex getHexByChar(char c) {
        Hex hex = hexMapCharIndex.get(c);
        if (null == hex) {
            throw new IllegalStateException("hexadecimal value overflow.\n");
        }
        return hex;
    }

    public enum Hex {
        x00(0x00, '0'),
        x01(0x01, '1'),
        x02(0x02, '2'),
        x03(0x03, '3'),
        x04(0x04, '4'),
        x05(0x05, '5'),
        x06(0x06, '6'),
        x07(0x07, '7'),
        x08(0x08, '8'),
        x09(0x09, '9'),
        x0a(0x0a, 'a'),
        x0b(0x0b, 'b'),
        x0c(0x0c, 'c'),
        x0d(0x0d, 'd'),
        x0e(0x0e, 'e'),
        x0f(0x0f, 'f');

        private final int value;
        private final char hex;

        Hex(int value, char hex) {
            this.value = value;
            this.hex = hex;
        }

        public int getValue() {
            return value;
        }

        public char getChar() {
            return hex;
        }
    }


}
