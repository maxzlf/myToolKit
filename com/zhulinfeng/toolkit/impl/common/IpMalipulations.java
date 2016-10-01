package com.zhulinfeng.toolkit.impl.common;

import com.zhulinfeng.toolkit.exceptions.InvalidArgumentException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpMalipulations {
    private IpMalipulations() {
        throw new IllegalStateException();
    }

    public static String intToIpAddr(int ip){
        String ipaddr = "";
        int iMask = 0x000000FF;
        int iCount;

        for (iCount = 0; iCount < Integer.SIZE/Byte.SIZE; iCount++){
            String sTmp = String.valueOf(ip & iMask);
            if (0 == iCount) {
                ipaddr = sTmp;
            } else {
                ipaddr = sTmp + "." + ipaddr;
            }
            ip >>>= 8;
        }

        return ipaddr;
    }

    public static long string2Int(String ipAddr){
        String[] strs = ipAddr.split("\\.");
        long iIp = 0;
        long itmp;

        for (String str : strs){
            iIp <<= 8;
            itmp = Integer.parseInt(str);
            iIp |= itmp;
        }

        return iIp;
    }

    public static void verifyIp(String arg) throws InvalidArgumentException {
        Matcher mIpAddr = Pattern.compile("(((25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))).){3}(25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))").matcher(arg);
        if (!mIpAddr.matches()) {
            throw new InvalidArgumentException(arg);
        }

    }

}
