/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-20
 * @description StringBuilder vs StringBuffer vs String(immutable)
 * StringBuffer: 需要new an object append()
 * String: +, 直接赋值
 * 1. for/while/if loop: use StringBuilder and StringBuffer to return the same object
 * 2. public synchronized StringBuffer append(StringBuffer sb) // 保证thread safety
 * StringBuffer: used for multi-threads (线程安全操作)
 * StringBuilder: used for a single thread (线程不安全操作)
 *
 */
public class TestDemo {
    /*
     * StringBuffer/StringBuilder -> String
     * 调用 .toString()
     * @return String
     */
    public static String func2() {
        StringBuilder sb = new StringBuilder("dkjf");
        return sb.toString();
    }
    public static StringBuffer func3() {
        String str = "dfd";
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        return sb; // string -> stringBuffer
    }
        /*
    * String -> StringBuffer or StringBuilder
    * 使用构造方法
    * @return new...
    */
    public static StringBuffer func() {
        String str = "badf";
        return new StringBuffer(str);// str to StringBuffer: need to use key word new,是个构造方法
    }
    public static void main4(String[] args) {
        StringBuilder sb = new StringBuilder("abcdef");
        sb.reverse();
        System.out.println(sb);
    }
    public static void main3(String[] args) {
        String str = "abcdef";
        StringBuilder sb = new StringBuilder();
        sb.append(str); // String -> StringBuilder
        for (int i = 0; i < 10; i++) {
            // 源代码的编译
            sb.append(i);
            str = sb.toString(); // StringBuilder -> String
            // str += i; // 会产生很多StringBuilder对象,类似与上面两行的代码
        }
        System.out.println(str);
    }

    public static void main2(String[] args) {
        // 普通的String拼接，底层会被优化为StringBuilder
        //String str = "abcdef";
        StringBuilder sb = new StringBuilder();
        sb.append("abcdef");
        //str += "123";
        sb.append("123");
        //str = sb.toString();
        System.out.println(sb);
    }
    public static void main1(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("adf");
        stringBuilder.append("fda"); // return the current object (this); will not create a new object
        stringBuilder.append("123"); // return the current object (this); will not create a new object
        stringBuilder.append("skkj").append("dkf").append("dfkld");
        System.out.println(stringBuilder);
    }



}
