package com.zhulinfeng.toolkit.impl.common;

public class OutPutTable {
    private static int LINE_LENGTH = 80;
    private static int SPLIT_LENGTH = LINE_LENGTH / 3;
    public static int BIG_SUMMERY_LENGTH = 20;
    public static int SMALL_SUMMARY_LENGTH = 10;

    private OutPutTable() {
        throw new IllegalStateException();
    }

    public static String getLine() {
        return nChar(LINE_LENGTH, '-') + "\n";
    }

    public static String getSplit() {
        return nChar(SPLIT_LENGTH, '-') + "\n";
    }

    public static String getTitle(String title) {
        return nChar((LINE_LENGTH-title.length())/2, ' ') + title + "\n";
    }

    public static String getSummary(String summary) {
        return String.format("%-20s : ", summary);
    }

    public static String getSummary(String summary, int width) {
        return summary + nChar(width-summary.length(), ' ') + " : ";
    }

    public static String nChar(int n, char c) {
        if (n <= 0) {return "";}

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<n; i++) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}
