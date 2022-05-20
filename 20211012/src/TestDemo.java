/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-10-12
 * Description: size of data type
 *              (w3schools) Wrapper classes provide a way to use primitive data types (int, boolean, etc..) as objects.
 */
public class TestDemo {

    public static void main(String[] args) {
        // & ^ ! ~
        // ternary operator
        int a = 10;
        int b = 20;
        int max = a > b ? a : b;
        System.out.println(max);
    }
    public static void main14(String[] args) {
        System.out.println(10 > 20 && 10 / 0 == 0); // false
        // System.out.println(10 > 20 || 10 / 0 == 0); // err exception / by zero
        // System.out.println(10 < 20 || 10 / 0 == 0); // err exception / by zero
    }

    public static void main13(String[] args) {
        // logical operators: && || !
        // && support shortcut: condition 1 && condition 2, if condition 1 is false, it will skip condition 2
        // ||: if 1 condition is true, return true. Support shortcut too as && And operator.

        int a = 10;
        int b = 20;
        int c = 30;
        System.out.println(a < b && b < c); // t
        System.out.println(a < b || b > c); // t
        System.out.println(!(a < b)); // f


    }
    public static void main12(String[] args) {
        //relational operators: == != < > <= >=, return true or false
        int a = 10;
        int b = 20;
        System.out.println(a == b); // f
        System.out.println(a != b); // t
        System.out.println(a < b); // t
        System.out.println(a > b); // f
        System.out.println(a <= b); // t
        System.out.println(a >= b); // f
    }

    public static void main11(String[] args) {
        int a = 10;
        a++;
        System.out.println(a); // 11

        int c = 10;
        ++c;
        System.out.println(c); // 11

        int a1 = a++; // a1 = a, a = a + 1; a1 != c2
        int c2 = ++c; // c = c + 1, c2 = c; a1 != c2
        System.out.println(a1); //11
        System.out.println(c2); //12
    }

    public static void main10(String[] args) {
        int a = 10;
        a += 1;
        System.out.println(a);

        short s = 10;
        // s = s + 9; err
        s = (short) (s + 9);
        s += 9;
    }

    public static void main9(String[] args) {
        // + - * / %
        int a = 1;
        int b = 2;
        // a/b, divisor b can't be 0. / by zero exception
        System.out.println(a/b); // 0

        System.out.println(10 % 3); //1
        System.out.println(11.5 % 2); //1.5
        System.out.println(-10 % 3); // -1
        System.out.println(10 % -3); // 1
        System.out.println(-10 % -3); // -1
    }

    public static void main8(String[] args) {
        // wrapper class
        // int -> Integer char->Character
        String str = "123";
        int ret = Integer.valueOf(str);
        System.out.println(ret + 1); // 124
    }

    public static void main7(String[] args) {
        // wrapper class for primitive data types.
        int num = 10;
        String ret = String.valueOf(num);
        System.out.println(ret);

        String ret2 = num + "";
    }

    public static void main6(String[] args) {
        // can't cast between int and boolean datatype
        int a = 10;
        // boolean b = (boolean) a; err

        boolean c = true;
        // int d = (int) c; err

        byte b = 127; // -128 ~ 127

        byte f = 1;
        byte d = 2;
        // byte e = d + f; err. If number is < 4 bytes, CPU will convert it to int type
        // c and d are int during calculation.
        byte g = (byte) (d + f);
        byte g1 = 1 + 2; // byte g1 = 3. 1 and 2 are constants. when compiling, it is compiled to 3 already.
        System.out.println(g);
    }

    public static void main5(String[] args) {
        // datatype cast: Java is a strong typed language
        int a = 10; // 4 bytes
        long b = a; // 8 bytes
        System.out.println(b);

        long l = 12;
        // int c = l; // err
    }

    public static void main4(String[] args) {
        // constants: literal constant and with final keyword. initialize once
        // constant: compile time
        // variable: run time
        final int SIZE = 10;
        // SIZE = 99; //err
    }

    public static void main3(String[] args) {
        // variables, 找作用域的时候，去找curly braces
        // 成员变量是在类的内部，方法的外部。又分为普通成员变量和静态成员变量
        int a = 10; // local variable
    }

    public static void main2(String[] args) {
        // char type
        char ch = 'a';
        // String: pass by reference
        String str = "hello";
        System.out.println(str);
        // attn:
        System.out.println("hel" + "lo"); // concatenation
        System.out.println("hello" + 10 + 20); // hello1020: string + other data type = string
        System.out.println("hello" + (10 + 20)); // hello30
        System.out.println(10 + 20 + "hello"); // 30hello: calculation order
        System.out.println(10 + "" + 20 + "hello"); // 1020hello
        System.out.println("a=" + 10 + ", b=" + 20); // a=10, b=20

        // Escape Character
        String s1 = "bit";
        System.out.println(s1); // bit
        System.out.println("\"bit\""); // "bit"
        System.out.println("\\bit\\"); // \bit\
    }

    public static void main1(String[] args) {
        System.out.println("hello");
        short s = 10; // 2 bytes    16 bits     range: -2^15 ~ 2^15-1
        boolean flg = true; // This type only takes true or false. 1 bit
        System.out.println(flg);
    }
}
