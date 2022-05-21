import java.util.Scanner;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-10-16
 * Description: if else switch for while do while()
 * Code quality
 * 1. readable
 * 2. comment
 * 3. efficiency
 */
public class TestDemo {
    public static void main(String[] args) {
        // continue
        // find the numbers that is divisible by 3 between 1 to 10
        int i = 1;
        while (i < 10) {
            if (i % 3 != 0) {
                i++;
                continue; // finishes the current loop, and loops again
            }
            System.out.println(i);
            i++;
        }
    }

    public static void main9(String[] args) {
        // break
        // find the first number that is divisible by 3 between 1 to 10
        int i = 1;
        while (i < 10) {
            if (i % 3 == 0) {
                System.out.println(i);
                break; // end all the loop
            }
            i++;
        }
    }

    public static void main8(String[] args) {
        // 5! + 4! + 3! +2! +1!
        int j = 1;
        int sum = 0;
        while (j <= 5) {
            int i = 1;
            int ret = 1;
            while (i <= j) {
                ret *= i;
                i++;
            }
            j++;
            sum += ret;
        }
        System.out.println(sum);
    }

    public static void main7(String[] args) {
        // 5!
        int n = 5;
        int i = 1;
        int ret = 1;
        while (i <= n) {
            ret *= i;
            i++;
        }
        System.out.println(ret);
    }

    public static void main6(String[] args) {
        // while loop for sum of 1 to 10
        int i = 1;
        int sum = 0;
        while (i <= 10) {
            sum += i;
            i++;
        }

        // for loop
        // do while
    }

    // long, float, double, boolean can not be used in switch statement
    public static void main5(String[] args) {
        //switch(data type)
        //1. byte and Byte
        //2. short and Short
        //3. int and Integer
        //4. char and Character
        //5. enum
        //6. String
        int a = 1;
        switch (a) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("not found");
                break;
        }
    }

    public static void main4(String[] args) {
        // leap year simplified loop
        Scanner kb = new Scanner(System.in);
        int year = kb.nextInt();
        if ((year % 100 != 0 && year % 4 == 0) || year % 400 == 0) {
            System.out.println(year + " is a leap year!");
        } else {
            System.out.println(year + " is not a leap year!");
        }
    }

    public static void main3(String[] args) {
        Scanner kb = new Scanner(System.in);
        int year = kb.nextInt();
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                System.out.println(year + " is a leap year!");
            } else {
                System.out.println(year + "is not a leap year!");
            }
        } else {
            if (year % 4 == 0) {
                System.out.println(year + " is a leap year!");
            } else {
                System.out.println(year + " is not a leap year!");
            }
        }
    }

    public static void main2(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        // String str1 = kb.next(); // will stop when it reads SPACE
        System.out.println(str);

        int n = kb.nextInt();
        if (n % 2 == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
    }

    public static void main1(String[] args) {
        // run the program in order
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
    }
}
