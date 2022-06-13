package demo1;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-12
 */
class Shape {
    public void draw() {
        System.out.println("Shape::draw()");
    }
}

class Rect extends Shape{
    @Override
    public void draw() {
        System.out.println("♦");
    }
}

class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}

class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("△");
    }
}
class Cycle extends  Shape {
    @Override
    public void draw() {
        System.out.println("●");
    }
}

public class Test {

    public static void main(String[] args) {
        Rect rect = new Rect();
        Flower flower = new Flower();
        Triangle triangle = new Triangle();

        Shape[] shapes = {triangle,rect,triangle,rect,flower,new Cycle()};
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public static void main3(String[] args) {
        Rect rect = new Rect();
        Flower flower = new Flower();
        Triangle triangle = new Triangle();

        String[] shapes = {"triangle", "rect", "triangle", "rect", "flower"};
        for (String s : shapes) {
            if(s.equals("triangle")) {
                triangle.draw();
            }else if(s.equals("rect")) {
                rect.draw();
            }else {
                flower.draw();
            }
        }
    }

    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void main2(String[] args) {
        Rect rect = new Rect();
        drawMap(rect);
        Flower flower = new Flower();
        drawMap(flower);
        Triangle triangle = new Triangle();
        drawMap(triangle);
    }

    public static void main1(String[] args) {
        Shape shape1 = new Rect();
        shape1.draw();
        Shape shape2 = new Flower();
        shape2.draw();
    }
}
