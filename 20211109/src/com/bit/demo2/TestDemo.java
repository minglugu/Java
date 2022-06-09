package com.bit.demo2;

import java.sql.SQLOutput;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-09
 * super keyword: https://www.scaler.com/topics/java/this-and-super-keyword-in-java/
 */
class Animal {
    public String name;
    public int age;
    protected int count;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("eat()");
    }
}

class Dog extends Animal{
    /*
    * default constructor
    * public Dog() {
    *   super();
    * }
    * */
    public Dog(String name, int age) {
        super(name, age); // The “super” keyword is used to invoke an immediate parent class constructor.
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

public class TestDemo {
    protected int value2 = 1;

    public static void main(String[] args) {
/*        Dog dog = new Dog("cute", 5);
        Animal animal = dog;*/
        Animal animal = new Dog("Cute", 19); // 父类引用  引用 子类对象
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
