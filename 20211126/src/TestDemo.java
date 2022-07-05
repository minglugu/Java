import java.net.Inet4Address;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-26
 *
 * question 1.  Object[] casting, jianshu.com/p/9783e29d7c20
 *              Object[] 和 Coffee[] 属于平级，没有父子关系，所以不能把Coffee[]数组类型转换成Object[]
 *
 * primitive type:byte, short, int,       long, float, double, char,      boolean
 * wrapper class: Byte, Short, Integer    Long, Float, Double, Character, Boolean
 * 包装类可以对数据进行处理。
 *
 * 数据和数据转换之间，比如说数字字符串变成数字，需要用方法来操作一下。
 *
 * boxing / unboxing
 *
 */
public class TestDemo {
    public static void main4(String[] args) {
        // boxing will use the valueOf()
        // Integer [-128, 127]
        Integer a = 129;
        Integer b = 129;
        System.out.println( a == b); // false

        /*
        * source code
        * valueOf low = -128
        * valueOf high = 127
        *     public static Integer valueOf(int i) {
                if (i >= IntegerCache.low && i <= IntegerCache.high)
                    // i = -128, -128+128=0 -> 0 index
                    // i = 127, 127+128 = 255 -> 255 index
                    // cache缓存数组，如果在index里面，那么就在[-128, 127]之间取值
                    // 如果index超出范围，那么就return一个new的对象，那么就是一个新的对象
                    return IntegerCache.cache[i + (-IntegerCache.low)];
                return new Integer(i);
              }
        */

/*        Integer c = 129;
        Integer d = 129;
        System.out.println( c == d); // true*/
    }

    public static void main3(String[] args) {
        Integer a = 123;// this is boxing
        int b = a; // unboxing (implicit)

        // explicit boxing
        Integer a2 = Integer.valueOf(123);
        Integer a3 = new Integer(123);

        // explicit unboxing
        int b2 = a2.intValue();
        double d = a2.doubleValue();

        System.out.println(a + " " + b);
    }

    public static void main2(String[] args) {
        // integer cast to string
        String a = "12345";
        int ret = Integer.valueOf(a); // 假如没有包装类，就得自己写个valueOf的函数。
        System.out.println(ret + 1);
        System.out.println("========================");
    }

    // type casting
    public static void main1(String[] args) {
        String[] strings = new String[10]; // OK
        Object o = new String[10]; // OK
        Object[] ob = new String[10]; // OK
    }

}
