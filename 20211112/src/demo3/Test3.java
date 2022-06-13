package demo3;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-12
 */

interface IA1 {
    void funcA();
}

interface IB1 extends IA1{
    void funcB();
}

class C implements IB1{
    @Override
    public void funcB() {
        System.out.println("fsafsa");
    }

    @Override
    public void funcA() {
        System.out.println("ewqrewqrq");
    }
}


public class Test3 {
}
