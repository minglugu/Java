import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-24
 * @Description 学习一下SimpleEmail这个类，可以用自己写的服务器来发邮件，或者第三方开源的服务器
 * 集合框架（Java Collection Framework）及背后的数据结构 and generic type 泛型
 *
 * interface, abstract class, class
 * interface extends interface
 * class implements interface
 * class extends (abstract) class
 * datatype in each class
 *
 * Interface (每个接口是一个标准) is defined as an abstract type used to specify the behavior of a class.
 *
 */
public class TestDemo {
    public static void main(String[] args) {
        // Methods in collection
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("hello1");
        //System.out.println(collection);

        // String[] objects = (String[])collection.toArray(); error: class cast exception
        // 如何以数组的形式，打印collection。Object[] toArray() 返回一个装有所有集合中元素的数组
        Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects));

        System.out.println("================");

/*        // 引用的是具体实现类ArrayList，所以查看ArrayList有没有具体实现clear的方法
        collection.clear();
        System.out.println(collection);

        System.out.println(collection.isEmpty());*/
    }

    public static void main1(String[] args) {
        // Collection的使用
        // Collection 是interface，引用的是具体的Arraylist的实现类
        // 不指定类型，那么可以存放各种数据类型,generic type
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("1");
        System.out.println(collection);

        // <> 中的类型，必须是class type，不是 primitive tupe，所以不写int
        Collection<Integer> collection2 = new ArrayList<>();
        collection2.add(1);
        collection2.add(2);
        collection2.add(3);
    }


}
