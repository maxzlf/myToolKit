package com.zhulinfeng.toolkit;

public class Main {

    public static void main(String[] args) {
        test();
//        new Start().start();
    }

    public static void test() {
        for (int i=0; i<48; i++) {
            for (int j=0; j<120; j++) {
                if (i>=16 && i<=32 && j>=40 && j<=80) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
}
