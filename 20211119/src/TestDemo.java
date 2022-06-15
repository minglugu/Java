import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-19
 */

public class TestDemo {

    public static void main(String[] args) {
        String s1 = "abc" + "def"; // string pool
        String s2 = new String(s1); // object
        if(s1.equals(s2)) {
            System.out.println("run the first if statement");
        }
        if(s1 == s2) {
            System.out.println("run the second if statement");
        }
    }

    // a tricky question
    public static boolean isAdmin(String userId) {
        // userId.toLowerCase() 产生了一个新对象，而“admin"是在常量池里的。所以两者不相等，是false
        return userId.toLowerCase() == "admin";
    }
    public static void main17(String[] args) {
        System.out.println(isAdmin("Admin")); // false
    }

    // a tricky question
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public static void main15(String[] args) {
        TestDemo ex = new TestDemo();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and "); // good and
        System.out.print(ex.ch); // gbc
    }
    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }

    public static void main14(String[] args) {
        String str = "adsjfhjd";
        String ret = str.concat("1214"); // 拼接的结果，不入池 （not in constant pool）
        System.out.println(ret);
        System.out.println(str.length()); // length() is a method
        int[] array = {1,2,3,4,5};
        System.out.println(array.length); // length here means attributes
        System.out.println(str.isEmpty());// false
    }
    public static void main13(String[] args) {

        String str = "adfdf";
        System.out.println(str.toUpperCase());

        String str2 = "JAJHDH";
        System.out.println(str2.toLowerCase(Locale.ROOT));
    }

    public static void main12(String[] args) {
        String str = "    abdfl dfdg ";
        String ret = str.trim(); // 去除两头的空格, 中间空格不能够去除
        System.out.print(ret);
        // verify if the end space is trimmed
        System.out.println("============");
    }
    public static void main11(String[] args) {
        String str = "abcd";
        System.out.println(str.substring(2));// cd, 从 index=2 开始； 如果index是0，那么不会返回新的对象
        System.out.println(str.substring(1,2));// [1, 2)


    }
    public static void main9(String[] args) {
        String str = "Java30 12&21#hello";
        String[] strings = str.split(" |&|#");// use | to separate mutiple regex value
        for (String ss:strings) {
            System.out.println(ss);
        }
    }
    public static void main8(String[] args) {
        // 分割需要注意的地方: ip address
        String str = "192.168.1.1";
        // String[] strings = str.split("."); // can't use . to split the ip address
        String[] strings = str.split("\\."); // can't use . to split the ip address
        // String[] strings = str.split(".", 7);
        for (String ss:strings) {
            System.out.println(ss);
        }
        System.out.println("==========");
        String str2 = "192\\168\\1\\1"; // 一个\，不能分割
        String[] strings1 = str.split("\\\\");
        for (String ss1:strings) {
            System.out.println(ss1);
        }
    }

    public static void main7(String[] args) {
        String str = "name=zhangsan&age=16";
        String[] strArr = str.split("&");
        for(String s:strArr) {
            // name=zhangsan  age=19
            System.out.println(s);
            String[] ss = s.split("="); // ss: name zhangsan
            for (String s1:ss) {
                System.out.println(s1);
            }
        }
    }

    public static void main6(String[] args) {
        String str = "ababcabcdabcde";
        String ret = str.replace('a', 'g'); // 只能传字符：产生new str object
        System.out.println(ret);
    }

    public static void main5(String[] args) {
        String str = "abdoddd";
        String temp = "abd";
        System.out.println(str.contains(str)); // true
        System.out.println("================");
        System.out.println(str.indexOf(temp)); // 0
    }

    public static void main4(String[] args) {
        // 字符串比较：真假比较 和 大小比较
        String str1 = "abc";
        String str2 = "Abc";
        System.out.println(str1.equalsIgnoreCase(str2));

        // 比较大小 compareTo()
        int val = str1.compareTo(str2); // 97(a)-65(A)
        System.out.println(val); // 23 = 97(a)-65(A)
    }
    public static void main3(String[] args) throws UnsupportedEncodingException {
        // 字节变成字符串： bytes to string
        byte[] bytes = {97,98,99,100};
        String str = new String(bytes, 1, 3);
        System.out.println(str);
        System.out.println("============================");
        // string to bytes
        // use utf-8 to the Chinese character 高博
        String str2 = "高博";
        String str3 = "dab";
        // byte[] 是把String按照一个字节一个字节的方式处理，适合网络传输，是对二进制数据来操作
        byte[] bytes1 = str2.getBytes("utf-8");
        // char[] 是把String按照一个字符一个字符的方式处理，适合对文本数据来操作。尤其是包含中文的时候
        byte[] bytes2 = str2.getBytes("GBK");
        System.out.println(Arrays.toString(bytes1));
        System.out.println(Arrays.toString(bytes2));
    }

    // 给定字符串，看是否都是由字母组成的
    public static boolean isLetterChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean flag = Character.isAlphabetic(c);
            if (flag == false) {
                return false;
            }
        }
        return true;
    }

    // 给定字符串，看是否都是由数字组成的
    public static boolean isNumberChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            // method 1
/*            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                System.out.println("不是全部由数字组成");
                return false;
            }*/
            // method 2
            char c = str.charAt(i);
            boolean flag = Character.isDigit(c);
            if (flag == false) {
                return false;
            }
        }
        return true;
    }

    public static void main2(String[] args) {
        String str = "31454";
        System.out.println(isNumberChar(str));

        String str2 = "dwj";
        System.out.println(isLetterChar(str2));
    }
    public static void main1(String[] args) {
        // array char into string
        char[] val = {'a', 'b', 'c', 'd', 'e'};
        String str = new String(val, 1,3);
        System.out.println(str); // bcd

        System.out.println("============");
        String str2 = "hello";
        char ch = str2.charAt(1); // e
        System.out.println(ch);

        // string to char[]
        char[] chars = str2.toCharArray();
        System.out.println(Arrays.toString(chars));


    }
}
