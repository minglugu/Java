import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-10-19
 */
public class TestDemo {
    // password
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 3;
        while (count != 0) {
            System.out.println("Please enter your password: ");
            String pwd = scanner.nextLine();
            if (pwd.equals("123456")) {
                System.out.println("Login is successful.");
                break;
            } else {
                count--;
                System.out.println("You have " + count + " times to enter the password.");
            }
        }
    }



    // method overload
    // 1. same method name
    // 2. parameters number and type are different
    // 3. return value doesn't matter (int, double)
    public static int add(int a, int b) {
        return a + b;
    }
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    public static double add(double a, double b) {
        return a + b;
    }

    public static void main19(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(add(a, b));

        double c = 10.1;
        double d = 20.3;
        System.out.println(add(c, d));
    }

    // void: not return value
    // another way of printing a swap result
    public static void main18(String[] args) {
        int[] arr = {10, 20};
        swap(arr);
        System.out.println("a = " + arr[0] + " b = " + arr[1]);
    }

    public static void swap(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }

    // an example that swapping numbers doesn't happen
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void main17(String[] args) {
        // in Java, the address of the stack is not accessible.
        int a = 10;
        int b = 20;
        System.out.println("before swapping: " + a + " " + b); // 10 20
        // swap the parameters, not the arguments a and b in main() method
        swap(a, b);
        System.out.println("after swapping:" + a + " " + b); // 10 20
    }

    // concept of method: reusable
    // sum of n!, n = 5
    // without methods
    public static int fac(int n) {
        int ret = 1;
        for (int i = 1; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }

    public static int facSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += fac(i);
        }
        return sum;
    }

    public static void main16(String[] args) {
        System.out.println(facSum(3));
    }
    /*
     * sum of 1 to n
     * @param n
     * @return sum
     */
    // n is parameter
    // A parameter is the variable listed inside the parentheses in the function definition.
    // An argument is the value that is sent to the function when it is called.
    // number of arguments, data type, return type need to match
    public static int sumAdd(int n) {
        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            sum += i;
        }
        System.out.println(sum);
        return sum;
    }

    public static void main15(String[] args) {
        sumAdd(10); // call sumAdd method, 10 is argument
    }

    public static void main14(String[] args) {
        // find number of 9 between 1 and 100
        // 9, 19, .... , 90, 91, 92..., 99
        int count = 0;
        for (int i = 1; i <= 100 ; i++) {
            if (i % 10 == 9) {
                count++;
            }
            if (i / 10 == 9) {
                count++;
            }
        }
        System.out.println(count);
    }

    // sum of 1/1 - 1/2 + 1/3 - 1/4 ... 1/100
    public static void main13(String[] args) {
        double sum = 0.0;
        int flag = 1;
        for (int i = 1; i <= 100; i++) {
            sum += 1.0/i * flag;
            flag = -1 * flag;
        }
        System.out.println(sum);
    }

    public static void main12(String[] args) {
        // find gcd
        // Euclidean algorithm
        int a = 24;
        int b = 18;
        int c = a % b;
        while (c != 0) {
            a = b; // a = 18
            b = c; // b = 6
            c = a % b; // 0
        }
        System.out.println("GCD is " + b);
    }

    // multiplication table
    public static void main10(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + i * j + "\t");
            }
            System.out.println();
        }
    }

    public static void main9(String[] args) {
        // leap year between year 1000 and 2000
        for (int year = 1000; year < 2000; year++) {
            if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
                System.out.println(year + " is a leap year.");
            }
        }
    }

    // Method 3: check if a number is a prime number.
    public static void main8(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 2;
        for (; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println(n + " is not a prime");
                break;
            }
        }
        // 2 cases
        // if i == n, n is prime
        if (i > Math.sqrt(n)) {
            System.out.println(n + " is a prime");
        }
    }
    // Method 2: check if a number is a prime number
    // Baidu interview question
    // n a*b: 16: 1*16 2*8 4*4. There exists a number that is smaller than n/2.
    // reducing the size of comparison
    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 2;
        for (; i < n/2; i++) {
            if (n % i == 0) {
                System.out.println(n + " is not a prime");
                break;
            }
        }
        // 2 cases
        // if i == n, n is prime
        if (i > n/2) {
            System.out.println(n + " is a prime");
        }
    }

    // Method 1: check if a number is a prime number
    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 2;
        for (; i < n; i++) {
            if (n % i == 0) {
                System.out.println(n + " is not a prime");
                break;
            }
        }
        // 2 cases
        // if i == n, n is prime
        if (i == n) {
            System.out.println(n + " is a prime");
        }
    }

    // age range
    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n > 0 && n < 18) {
            System.out.println("Children and teenagers");
        } else if (n >= 18 && n < 29) {
            System.out.println("Young adults");
        } else if (n >= 29 && n < 56) {
            System.out.println("Middle aged groups");
        } else {
            System.out.println("Seniors");
        }

        System.out.println("Please input an integer.");
    }

    // guessing an integer name
    public static void main4(String[] args) {
        Random random = new Random();
        int rand = random.nextInt(100); // [0-99)
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please input an integer:");
            int n = scanner.nextInt();

            if (n < rand) {
                System.out.println("number is small.\n");
            } else if (n == rand) {
                System.out.println("correct");
                break;
            } else {
                System.out.println("number is large.\n");
            }

        }
    }

    // continuously input from scanner
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(n);
        }
    }

    // input from scanner
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str);

        int n = scanner.nextInt();
        System.out.println(n);

        double d = scanner.nextDouble();
        System.out.println(d);
    }

    public static void main1(String[] args) {
        System.out.println("new line");
        System.out.print("no new line");
        // System.out.printf(format, msg);
        System.out.printf("%d\n", 10);
    }
}


