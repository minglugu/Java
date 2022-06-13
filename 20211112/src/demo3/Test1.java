package demo3;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-12
 */
interface IShape {
    void draw();//抽象方法
   /* default public  void func(){
        System.out.println("fsafa");
    }*/
    /* default public  void func2(){
        System.out.println("fsafa");
    }
    public static void funcStatic() {
        System.out.println("fafa");
    }*/
}
class Rect implements IShape {

    @Override
    public void draw() {
        System.out.println("♦");
    }

    /*@Override
    public void func() {
        System.out.println("重写接口当中的默认方法");
    }*/
}

class Flower implements IShape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

class Triangle implements IShape {
    @Override
    public void draw() {
        System.out.println("△");
    }
}
class Cycle implements IShape {
    @Override
    public void draw() {
        System.out.println("●");
    }
}

public class Test1 {

    public static void drawMap(IShape iShape) {
        iShape.draw();
    }

    public static void main(String[] args) {
        Rect rect = new Rect();
        Flower flower = new Flower();
        drawMap(rect);
        drawMap(flower);
    }

    public static void main1(String[] args) {
        //IShape iShape = new IShape();error
        IShape iShape = new Rect();
        iShape.draw();
    }
}
