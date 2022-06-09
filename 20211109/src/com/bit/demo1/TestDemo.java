package com.bit.demo1; // classes are in this package; names are small letters

import com.bit.demo2.Test2;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-09
 */
public class TestDemo extends Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println(test2.value);
    }
    public static void main1(String[] args) {
        Test test = new Test();
        System.out.println(test.val);
    }

}
