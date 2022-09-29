/**
 * Date: 2022/2/22
 */
interface A {

}

class OuterClass {
    public int data1 = 1;
    private int data2 = 2;
    public static int data3 = 3;
    //实例内部类：你可以把他当做 是外部类的一个普通实例的成员
    class InnerClass {
        public int data1 = 999999;
        public int data4 = 4;
        private int data5 = 5;
        public static final int data6 = 6;
        public InnerClass() {
            System.out.println("不带参数的内部类的构造方法！");
        }
        public void test() {
            System.out.println(OuterClass.this.data1);
            System.out.println(this.data1);
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
            System.out.println("InnerClass::test()");
        }
    }

    public void func1() {
        //static int a = 10; 属于类的  不属于对象的
        System.out.println("OuterClass::func1()");
    }
}

//
class MyLinkedList {
    class Node {

    }
}

public class TestDemo extends OuterClass.InnerClass {

    public TestDemo(OuterClass out) {
        out.super();
    }

    /*public void func() {
        class Test {
            public int a;
        }
        //缺点：只能在当前方法当中使用
    }*/

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
//        outerClass.func1();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.test();
    }
}