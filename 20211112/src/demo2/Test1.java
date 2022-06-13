package demo2;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-12
 */
abstract class Shape {
    //public int a;
    /*public void func() {
        System.out.println("测试普通方法！");
    }*/
    public abstract void draw();//抽象方法
}

abstract class A extends Shape{
    public abstract void funcA();
}
class B extends A {
    @Override
    public void funcA() {

    }

    @Override
    public void draw() {

    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("♦");
        //super.func();
    }
}
class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("△");
    }
}
class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("●");
    }
}

public class Test1 {

    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Shape shape = new Rect();
        drawMap(shape);
        Cycle cycle = new Cycle();
        drawMap(cycle);
        //Shape shape2 = new Shape();
    }
}