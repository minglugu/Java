import com.bit.demo1.Test;

import java.util.Arrays;
import java.util.*;
import java.sql.*;
import static java.lang.System.*;
import static java.lang.Math.*;


/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-09
 * @descripton      package (A package in Java is used to group related classes)
 *              vs  import (is used to bring certain classes or the entire packages, into visibility.)
 */
public class TestDemo {
    public static void main(String[] args) {
        Test test = new Test();
        // System.out.println(test.val); // val is not public in com.bit.demo1.Test; cannot be accessed from outside package
    }

    public static void main3(String[] args) {
        out.println("abc");
        out.println(max(10, 20));
    }

    public static void main2(String[] args) {
        // 区别是sql里的date，还是util里的date
        java.util.Date date = new java.util.Date(); // This is one way of writing it
        // java.util.Date date = new java.util.Date(); // not convenient
        System.out.println(date);
    }

    public static void main1(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
    }
}
