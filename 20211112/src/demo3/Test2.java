package demo3;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-12
 */
interface IA {
    int A = 10;
    void funcA();//public abstract
}
interface IB {
    void funcB();
}
abstract class BClass {

}

// a class can only extend one super class, but can implement multiple interfaces(features)
class AClass extends BClass implements IA,IB {
    public void funcA() {
        System.out.println("A::funcA()");
        System.out.println(A);
    }

    @Override
    public void funcB() {
        System.out.println("A::funcB()");
    }
}

public class Test2 {

    public static void main(String[] args) {
        final int a = 10;
        System.out.println(a);
    }
}
