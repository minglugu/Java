/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-15
 * @description: class, object, abstract class, interface, encapsulation, inheritance, polymorphism, arraylist
 */
class A {
    static {
        System.out.println("A的静态代码块执行了");
    }
    {
        System.out.println("A的实例代码块执行了");

    }
    public A() {
        System.out.println("A的构造方法执行了");

    }
}

class B extends A{
    static {
        System.out.println("B的静态代码块执行了");
    }
    {
        System.out.println("B的实例代码块执行了");

    }
    public B() {
        System.out.println("B的构造方法执行了");

    }
}

class C extends B {

}

public class TestDemo {
    public static void main(String[] args) {
        /* order of print
        * A的静态代码块执行了
        B的静态代码块执行了
        A的实例代码块执行了
        A的构造方法执行了
        B的实例代码块执行了
        B的构造方法执行了*/
        B b = new B();
    }

    public static void main1(String[] args) {
        A a0 = new A();
        A a1 = new B();
        A a2 = new C();
    }
}
