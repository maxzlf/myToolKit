package com.zhulinfeng.toolkit.impl.common;

import com.zhulinfeng.toolkit.exceptions.InvalidArgumentException;

public class NumberMalipulations {
    private NumberMalipulations() {
        throw new IllegalStateException();
    }

    public static int turnStrToInt(String arg) throws InvalidArgumentException {
        try {
            long ipLong = Long.parseLong(arg);
            if (ipLong > (2L * Integer.MAX_VALUE + 1L) || ipLong < (long) Integer.MIN_VALUE) {
                throw new InvalidArgumentException(arg);
            }
            return (int) ipLong;
        } catch (Exception e) {
            throw new InvalidArgumentException(arg);
        }
    }

    public static long turnStrToLong(String arg) throws InvalidArgumentException {
        try {
            return Long.parseLong(arg);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException(arg);
        }
    }
}
