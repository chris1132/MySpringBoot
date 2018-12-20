package com.boot1.chovy.util;

/**
 * Created by wangchaohui on 2018/10/22.
 */
public class Test1 {

    public static int index = 1;
    public int index2 = 1;

    public void addIndex() {
        index += 1;
        index2 += 1;
    }

    public void printIndex() {
        System.out.println(index + ":" + index2);
    }
}
