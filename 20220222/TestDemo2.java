import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Date: 2022/2/22
 * Description: Comparator and PriorityQueue
 */
class OuterClass2 {
    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;
    //静态内部类:
    static class InnerClass {
        public int data4 = 4;
        private int data5 = 5;
        public static int data6 = 6;

        public static OuterClass2 out2 = new OuterClass2();

        public OuterClass2 out;
        public InnerClass(OuterClass2 out) {
            this.out = out;
        }

        public InnerClass() {

        }

        public void test() {
            System.out.println(out.data1);
            //System.out.println(out.data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
            System.out.println("InnerClass::test()");
        }
    }
}
class Test {
    public void test() {
        System.out.println("test()haha!");
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        new Test(){
            @Override
            public void test() {
                System.out.println("我是重写的test方法");
            }
        }.test();

        PriorityQueue<Integer> prio = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

    }
    public static void main2(String[] args) {
        OuterClass2.InnerClass innerClass = new OuterClass2.InnerClass();

    }
    public static void main1(String[] args) {
        OuterClass2 o = new OuterClass2();
        OuterClass2.InnerClass innerClass = new OuterClass2.InnerClass(o);
        innerClass.test();

    }
}