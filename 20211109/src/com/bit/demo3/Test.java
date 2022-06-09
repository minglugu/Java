package com.bit.demo3;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since yyyy-mm-dd
 */
class Animal {
    public String name = "bit";
    public int age;
    protected int count;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println(name + " eat()");
    }
}

class Dog extends Animal {
    /*
     * default constructor
     * public Dog() {
     *   super();
     * }
     * */
    public Dog(String name, int age) {
        super(name, age); // The “super” keyword is used to invoke an immediate parent class constructor.
    }

    @Override
    public void eat() {
        System.out.println(name + " munching");
    }
}

// is-a relation
class Bird extends Animal {
    public String wing;
    public String name;
    public Bird(String name, int age, String wing) {
        super(name, age);
        this.wing = wing;
    }

    public void fly() {
        System.out.println(super.name + "fly()" + super.age); // name is inherited from Animal class.
        //System.out.println(name + "fly()"); // name is the attribute of Bird class
    }
}

public class Test {
    protected int value2 = 1;

    public static void main(String[] args) {
        Animal animal = new Dog("Cute", 19);

        Animal animal2 = new Bird("chirp", 10,"fly");
        animal2.eat(); // no override eat(), bird uses Animal's eat()
        // 通过父类引用，只能访问父类自己的成员
        System.out.println(animal2.name); // It is chirp not bit, b/c bird has its own name chirp

        // dynamic binding: https://www.javatpoint.com/static-binding-and-dynamic-binding
        /*
        * 1. 父类引用 引用 子类的对象
        * 2. 通过这个父类引用 调用父类和子类 同名的覆盖方法（override）
        * 3. 返回值相同
        * 4. 在父子类的情况下
        * */
        animal.eat(); // will print dog's own eat method
    }

    /*
    * upcasting and downcasting reference URL:
    * https://www.javatpoint.com/upcasting-and-downcasting-in-java#:~:text=Upcasting%20and%20Downcasting%20in%20Java.%201%201%29%20Upcasting.,the%20Upcasting%2C%20we%20can%20...%202%202%29%20Downcasting.
    * */
    public static void main2(String[] args) {
        // 向上转型
/*        Dog dog = new Dog("cute", 5);
        Animal animal = dog;*/
        Animal animal = new Dog("Cute", 19); // 父类引用  引用 子类对象 upcasting
    }

    public static void main1(String[] args) {
        Dog dog = new Dog("cute", 5);
        // dog.name = "Cute";
        System.out.println(dog.name);
        dog.eat();

        // use parent constructor
        Bird bird = new Bird("Chirp", 5, "I'd like to fly");
        // bird.name = "Chirp";
        bird.eat();
        // nullfly() if using line 48 System.print...
        // Chirpfly() if using line 47
        bird.fly();
    }
}
