/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-10-21
 */
public class TestDemo2 {
    // recursion concept
    // 1. base condition
    // 2. call the recursive function itself

    // frogs jump n steps of stairs. It can jump one step, or two steps.
    // How many ways of jump?
    public static int fun1(int n) {

        if(n == 1 || n == 2) {
            return n;
        }

        return fun1(n - 1) + fun1(n - 2);
    }

    // n！using recursion
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        int ret = n * factorial(n - 1);
        return ret;
    }

    // sum from 1 to n
    public static int sumAdd(int n) {
        int sum = 0;
        if (n == 1) {
            return 1;
        }
        return n + sumAdd(n-1);
    }

    // fib2 using 循环 迭代实现
    public static int fib2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }



    // fibonacci
    // fib 1
    public static int fib(int n) {
        if (n ==1 || n == 2) {
            return 1;
        }
        return fib(n-1) + fib(n-2); // lots of repeated calculation, not ideal
    }

    // sum of each digit in a number 1234 -> 1+2+3+4
    public static int sumAll(int n) {
        if (n < 10) {
            return n;
        } else {
            return sumAll(n/10) + n % 10;
        }
    }

    // @02:27:00 on 2021-10-21
    // print a number in order 1234 ->1 2 3 4
    public static void printDigits(int n) {
        if (n <= 9) {
            System.out.print(n + " ");
        } else {
            printDigits(n / 10);
            System.out.print(n % 10 + " ");
        }
    }

    // example1
    public static void func(int n) {
        // base condition
        if (n == 1) {
            return;
        }
        func(n-1);
    }

    // no base condition, so infinite recursion causing StackOverflowError
    /*public static void func() {
        func();
    }*/

    public static void main(String[] args) {
        // func(6);
        // System.out.println(factorial(5));
        // printDigits(1234);
        // System.out.println(sumAll(1234));
/*        System.out.println(fun1(1));
        System.out.println(fun1(2));
        System.out.println(fun1(3));
        System.out.println(fun1(4));*/
    }
}
