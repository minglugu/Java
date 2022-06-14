import java.lang.reflect.Field;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-17
 * @Description String is immutable
 * 字符串的拼接，会被优化为StringBuilder对象（concatenation of string wll be optimized to the object of StringBuilder）
 */
public class TestDemo2 {

        // use refection to modify a str
        public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
            String str = "abcde";
            Class<?> c1 = String.class;
            // 获取 String 类中的 value 字段. 这个 value 和 String 源码中的 value 是匹配的.
            Field valueField = c1.getDeclaredField("value");
            // 将这个字段的访问属性设为 true
            valueField.setAccessible(true);
            // 把 str 中的 value 属性获取到.
            char[] value = (char[]) valueField.get(str);
            // 修改 value 的值
            value[0] = 'h';
            System.out.println(str);
        }

    public static void main1(String[] args) {
        // every concatenation of a string will create a new object
        // total： 5 new objects
        // less efficient
        String str = "hello";
        str = str + " world";
        str += "!!!";
        System.out.println(str);
    }
}
