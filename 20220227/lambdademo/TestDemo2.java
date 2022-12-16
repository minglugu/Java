package lambdademo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 * Description: lambda functions
 */
class Test {
    public void func(){
        System.out.println("func()");
    }
}
public class TestDemo2 {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "bit");
        map.put(3, "hello");
        map.put(4, "lambda");

        map.forEach((key,value)-> System.out.println("key:"+key+" value:"+value));

        System.out.println("======================");
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println("key:"+integer+" value:"+s);
            }
        });
    }

    public static void main2(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("zello");
        list.add("bit");
        list.add("hello");
        list.add("lambda");

//        list.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

        list.forEach(s -> System.out.println(s));

        //list.sort(((o1, o2) -> o1.compareTo(o2)));

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("============");

        list.forEach(s -> System.out.println(s));

    }


    public static void main1(String[] args) {
        int a = 100;
//        a = 99;
        new Test(){
            @Override
            public void func() {
                System.out.println("我是内部类，且重写了func这个方法！");
                System.out.println("捕获变量,要么是常量，要么未发生改变过："+a);
            }
        }.func();
    }
}