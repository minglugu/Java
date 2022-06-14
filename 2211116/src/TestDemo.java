import java.util.Arrays;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-16
 * @Description： String: public final class String extends Object implements Serializable, Comparable<String>, CharSequence
 * String class can not be inherited
 * contant pools: https://www.baeldung.com/jvm-constant-pool
 * Class file constant pool: int a = 10; 磁盘上
 * runtime constant pool: 当程序把编译好的字节码文件，加载到JVM中，会生成一个运行时常量池【方法区】，实际上是Class文件常量池
 * string constant pool: 存放字符串(" ")常量池，本质上是hash table，StringTable
 * constant pool contains symbolic references that are used to locate the actual objects.
 * Purpose of using constant pool: increases the efficiency
 */
public class TestDemo {
    public static void func(String str, char[] array) {
        str = "gaobo"; // 形参 改变了指向
        array[0] = 'p';
    }

    public static void func2(String str) {
        // have to be in this order to avoid null pointer exception
        if (str == null || str.length() == 0) {
        }
    }
    
    public static void main(String[] args) {
        // string的本质是数组，是不能修改的。
        // 只能通过反射来修改String里面的值
        int[] array = {1,2,3,4,5};
        // array = {3,4,5,6}; error: 数组整体的赋值，只有一次机会，就是在定义的时候
        array = new int[]{3,4,5,6}; // create a new object

        String str1 = null; // str1这个引用 不指向如何对象
        String str2 = ""; // str2这个引用 指向的字符串是空的
        System.out.println(str2.length());
    }

    public static void main10(String[] args) {
        String str1 = null;
        String str2 = "11";
        // null pointer exception
       // System.out.println(str1.equals(str2)); error str1 is null

        // false, str2 is not null
        System.out.println(str2.equals(str1));
    }

    public static void main9(String[] args) {
        // 先入池
        String str1 = "11";
        // 发现11 对象已经入池，那么不会再入池，所以str1和str2所指向的对象不是同一个
        String str2 = new String("1") + new String("1");
        str2.intern();
        System.out.println(str1 == str2); // false： compare address
        System.out.println(str1.equals(str2)); // true
    }

    public static void main8(String[] args) {
        // 2021-11-17 video @2:17:00 explains string's value (char[]) and hash: see the library code of String
        // str2 is the object of StringBuilder, StringBuilder.toString()
        String str2 = new String("1") + new String("1");
        // intern() can be used to return string from memory if it is created by a new keyword.
        // It creates an exact copy of the heap string object in the String Constant Pool.
        str2.intern(); // 手动入池
        String str1 = "11";
        // 1. false without intern(),str1 and str2 are different objects
        // 2. true with str2.intern()
        System.out.println(str1 == str2);
    }

    public static void main7(String[] args) {
        String str1 = "11";
        // str2 is the object of StringBuilder, StringBuilder.toString()
        String str2 = new String("1") + new String("1");
        System.out.println(str1 == str2); // false,str1 and str2 are different objects

    }

    public static void main6(String[] args) {
        String str1 = "hello";
        String str2 = "he" + "llo";// 此时他俩都是常量，compile的时候，就已经确定好了，这是“hello”
        // true: str1 and str2 point at the same address. String "hello" in constant pool
        System.out.println(str1 == str2); // true

        // str4 拼接的是两个对象，拼接后，不会放在常量池里面。str4指向拼接好以后的对象
        String str3 = "he";
        String str4 = str3 + "llo"; // str3 is a variable, which is not known when compiling
        System.out.println(str1 == str4); // false
    }

    public static void main5(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        // true: str1 and str2 point at the same address. String "hello" in constant pool
        System.out.println(str1 == str2);

    }

    public static void main4(String[] args) {
        // 2021-11-17 video @1:20:00 explains string's value (char[]) and hash: see the library code of String
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1 == str2); // false, because they compare the reference addresses
        System.out.println(str1.equals(str2)); // true, compare the content
    }

    public static void main3(String[] args) {
        String str = "abddd";
        char[] chars = {'b', 'i', 't'};
        func(str, chars);
        System.out.println(str); // abddd
        System.out.println(Arrays.toString(chars)); //[p,i,t]
    }
    public static void main2(String[] args) {
        // 1. Strings are constant; their values cannot be changed after they are created.
        // 2. String buffers support mutable strings. Because String objects are immutable they can be shared
        String str = "adfj"; // constant
        String str2 = str;
        System.out.println(str);
        System.out.println(str2);
        str = "bit"; // change the reference: str points at "bit" address. It does not change the constant value
        System.out.println("============");
        System.out.println(str); // bit
        System.out.println(str2); // adfj
    }
    public static void main1(String[] args) {
        // three ways of creating a string
        // method 1.
        String str = "abe";
        // method 2. use constructor to create a string object
        String str2 = new String("ldd");
        // method 3. chars[] into String
        char[] chars = {'a', 'b', 'c'};
        String str3 = new String(chars); // chars[] into String

        System.out.println(chars); //abc


    }
}

