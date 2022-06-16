import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-23
 * @Description: Exception
 * 1. defensive: LBYL: look before you leap
 *               EAFP: It's easier to ask forgiveness than permission： 先操作，遇到问题再处理
 *               EAFP: 这是异常的核心思想
 *    可能发生的错误，放在try{} block 里面，eg 课件里面的游戏的例子
 *    catch需要加，finally可加可不加
 *    check exception and error through idk
 *
 *    checked exception vs unchecked exception
 */
class Person implements Cloneable{
    public int id;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class TestDemo {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(readFile());
    }

    public static void main12(String[] args) {
        System.out.println();
    }
    public static String readFile()  {
        // 尝试打开文件，并读其中的一行
        File file = new File("d:/test.txt");
        // 使用文件对象构造 Scanner 对象
        // method 1. Add "throws FileNotFoundException" in the method signature，
        // 相当于将处理动作交给上级调用者，如果再处理不了异常，就交给JVM处理
        // Scanner sc = new Scanner(file);
        // method 2. use try catch
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return sc.nextLine();
    }

    // throws in signature
    public static int func5(int x, int y) throws RuntimeException{
        if(y == 0) {
            // System.out.println(10/x); 已经抛出异常了，不会执行下面一行代码
            throw new ArithmeticException("/ by 0"); // 自定义异常
            // 抛出自定义的异常
            // throw new RuntimeException("x == " + 10);
        }
        return x / y;
    }

    public static void main11(String[] args) {
        //func5(10, 0);
       try {
            func5(10,0);
        }catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
    // 打印是20，所以避免在finally写return
    public static int func4() {
        int a = 10;
        try {
            //
            //System.out.println(10/0);
            return a;
        }catch (ArithmeticException e) {
            e.printStackTrace();
        }finally {
            return 20;
        }
    }

    // 也可以这么写
    public static void func3(int n) throws ArithmeticException{
        System.out.println(10/n);
    }

    public static void main10(String[] args) {
        try {
            func2(0);
        }catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    // 也可以这么写
    public static void func2(int n) {
        try{
            System.out.println(10/n);
        }catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
    public static void main8(String[] args) {
        // scanner.close 在finally里就没有了，见main7()
        // try执行完毕后，自动调用Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(10 / n);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("Input type is not correct!");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("/ 0 error");
        } finally {
            // finally一般用于资源的关闭。不管是否发生异常，finally一定会执行
            System.out.println("finally执行了");
        }
    }

    public static void main7(String[] args) {
        Scanner scanner = new Scanner(System.in);
/*        // 可能出现异常，所以写在try catch里面
        int n = scanner.nextInt();
        System.out.println(10/n);
        scanner.close();*/
        try {
            int n = scanner.nextInt();
            System.out.println(10/n);
        }catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("Input type is not correct!");
        }catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("/ 0 error");
        }finally {
            // finally一般用于资源的关闭。不管是否发生异常，finally一定会执行
            scanner.close();
            System.out.println("finally执行了");
        }
    }

    public static void main6(String[] args) {
        // with try catch, "throws CloneNotSupportedException" will not be in signature
        Person person = new Person();
        try {
            Person person1 = (Person) person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
    public static void func() {
        // error
        func(); // recursion without base condition, causing stackOverflowError
    }

    public static void main5(String[] args) {
        func();
    }
    public static void main4(String[] args) {
        int[] arr = {1,2,3};
        try {
            arr = null;
            System.out.println(arr[2]);// null pointer exception
            System.out.println("this line will not be printed due to the error of the above line");
        }catch (ArrayIndexOutOfBoundsException | NullPointerException e) { // 可以用 “|” 来表示or，异常可以写在一起
            e.printStackTrace(); // 打印栈上的信息
            System.out.println("catch an exception of index out of bounds or null pointer exception");
        }
        System.out.println("hello");
    }
    public static void main3(String[] args) {
        int[] arr = {1,2,3};
/*        System.out.println(arr[5]);
        System.out.println("hello"); // above code is throwing error, this line will not run*/
        try {
            arr = null;
            System.out.println(arr[2]);// null pointer exception
            System.out.println("this line will not be printed due to the error of the above line");
        }catch (ArrayIndexOutOfBoundsException e) { // catch这个代码块需要加上去,不能执行空指针异常
            e.printStackTrace(); // 打印栈上的信息
            System.out.println("catch an exception of index out of bounds");
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(n); // input mismatch exception
    }

    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();
        Person person2 = (Person) person1.clone(); // compile error

        // runtime error(程序已经编译通过)
/*        int[] arr = {1,2,3};
        System.out.println(arr[9]); // indexoutofbounds
        System.out.println(10/0); // arithmetic exception: / by zero
        String str = null;
        System.out.println(str.length()); // null pointer exception*/
    }

}

