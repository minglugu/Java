import java.util.Scanner;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-10-21
 * @description coding exercises
 * */

public class TestDemo {


    // find the max of 2 numbers
    public static int max2(int a, int b) {
        return a > b? a : b;
    }

    public static int max3(int a, int b, int c) {
        int d = max2(a, b);
        int e = max2(d, c);
        return e; // max2(max2(a, b), c)
    }

    // digits on the odd positions are placed before even positions. Order doesn't matter
    // 1,2,3,4,5 -> 1,5,3,4,2
    // left moves to the right, and stops at even number
    // right moves to the left, and stops at odd number
    public static void swapOddEven(int[] array) {
        // index: left and right
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // left < right as a condition, b/c if all odd number in array, left will keep adding 1 and not stop.
            while (left < right && array[left] % 2 != 0) { // odd number
                left++;
            }
            while (left < right && array[right] % 2 == 0) { // even number
                right--;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }

    // method 2. start from array[0]
    public static int unique2(int[] intArray) {
        int ret = intArray[0]; // assign the initial value to array[0]
        for (int i = 1; i < intArray.length; i++) {
            ret ^= intArray[i]; // start from ret = 0
        }
        System.out.println(ret);
        return ret;
    }

    // method 1. find a number that appears only once in an array
    // use XOR ^: 0^n=n, n^n=0
    public static int unique1(int[] intArray) {
        int ret = 0; // ret=0, != 1
        for (int i = 0; i < intArray.length; i++) {
            ret ^= intArray[i]; // start from ret = 0
        }
        System.out.println(ret);
        return ret;
    }

    public static void main(String[] args) {
        // int[] array = {1,2,3,2,1};
       //  unique2(array);
    }

    // newcoder X型图案, continously input numbers
    public static void printX(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) {
                    System.out.print("*");
                } else if(j == (n - 1 - i)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            printX(n);
        }

    }

    // print every digit of an integer
    // 123 -> 3 2 1
    public static void printDigits(int n) {
        while(n != 0) {
            System.out.print(n%10 + " ");
            n /= 10;
        }
    }

    //print digits in odd and even positions
    // 001101
    public static void printOne(int n) {
        for (int i = 30; i >= 0; i -= 2) {
            System.out.print(((n >> i) & 1) + " ");
        }
        System.out.println();
        for (int i = 31; i >= 1; i -= 2) {
            System.out.print(((n >> i) & 1) + " ");
        }
    }

    // find how many 1s in a number
    // method 1
    public static int countOnes(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        System.out.println(count);
        return count;
    }

    // method 2
    // n & (n-1) will remove the lowest 1 in the number
    public static int count1s(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        System.out.println(count);
        return count;
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        count1s(number);
    }

    // find Narcissistic numbers (3 digits)
    public static void findNum(int n) {
        for (int i = 1; i <= n; i++) {
            int count = 0; // how many digits in a number
            int temp = i;
            while (temp != 0) {
                count++;
                temp /= 10;
            }
            // get the digits number in n, temp = 0
            temp = i;
            int sum = 0;
            while (temp != 0) {
                sum += Math.pow(temp % 10, count) ;
                temp = temp / 10;
            }
            if (sum == i) {
                System.out.println(i);
            }
        }
    }

    public static void main0(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();///999999 (find numbers up to 6 digits)
        // findNum(n);
        // printOne(11);
        // printDigits(123);
        printX(5);
    }
}
