package lambdademo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: 12629
 * Date: 2022/2/27
 * Time: 17:11
 * Description:
 */
@FunctionalInterface
//函数式接口   无返回值没有参数
interface NoParameterNoReturn {
    void test();
    //void test2();
}

//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}
//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}


//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}

//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}
//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}

public class TestDemo {

    public static void main6(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        PriorityQueue<Integer> minHeap1 = new PriorityQueue<>(3, (o1,o2)->o1-o2);
    }

    public static void main5(String[] args) {
        NoParameterReturn noParameterReturn = ()->{return 10;};

        NoParameterReturn noParameterReturn2 = ()->10;

        int ret = noParameterReturn2.test();

        System.out.println(ret);

        OneParameterReturn oneParameterReturn = a->a+11;
        System.out.println(oneParameterReturn.test(10));

        MoreParameterReturn moreParameterReturn = (a,b)->a+b;
        System.out.println(moreParameterReturn.test(1,2));
    }

    public static void main4(String[] args) {
        int size = 10;
        size = 9;
        OneParameterNoReturn oneParameterNoReturn = (a)->{
            System.out.println(a);
            //System.out.println(size);
        };

        oneParameterNoReturn.test(10);

        OneParameterNoReturn oneParameterNoReturn2 = a->System.out.println(a);
        oneParameterNoReturn2.test(10);

        MoreParameterNoReturn moreParameterNoReturn1 = ( int a, int b)->{
            System.out.println(a+b);
        };

        MoreParameterNoReturn moreParameterNoReturn = (a,b)->System.out.println(a+b);
        moreParameterNoReturn.test(10,20);
    }

    public static void main2(String[] args) {
        NoParameterNoReturn parameterNoReturn = ()->System.out.println("重写方法！");
        parameterNoReturn.test();
    }

    public static void main1(String[] args) {
        NoParameterNoReturn parameterNoReturn = new NoParameterNoReturn(){
            @Override
            public void test() {
                System.out.println("重写方法！");
            }
        };
        parameterNoReturn.test();
    }
}