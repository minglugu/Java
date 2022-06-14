/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-17
 * @description Cloneable interface: https://www.javatpoint.com/cloneable-in-java
 * Cloneable is an empty interface, marker interface->meaning this class implementing cloneable can be cloned.
 * 创建对象的方式：
 * 1. new
 * 2. clone一个已经有的对象。 cloneable是个空接口-》标志接口-》代表当先这个类是可以被克隆的
 */

class Money implements Cloneable{
    public double m = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable{
    public int age;
    public Money money = new Money();

    public void eat() {
        System.out.println("To eat");
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person temp = (Person) super.clone();
        temp.money = (Money) this.money.clone();
        return temp;
        // return super.clone();
    }
}
public class TestDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        // deep copy of Money object in person2:
        // 1. change the override function in Person
        // 2. Money class implements cloneable interface and add override clone() in Money class
        Person person = new Person();
        Person person2 = (Person)person.clone();
        person2.money.m = 15.0;
        System.out.println(person.money.m); //12.5
        System.out.println(person2.money.m);//15.0
    }
    public static void main2(String[] args) throws CloneNotSupportedException {
        // money in person and persons refers to the same object
        Person person = new Person();
        Person person2 = (Person)person.clone();
        System.out.println(person.money.m); // 12.5
        System.out.println(person2.money.m); //12.5
        person.age = 5;
        person2.age = 8;
        System.out.println("===========");
        person.money.m = 12.8;
        System.out.println(person.money.m); // 12.8
        System.out.println(person2.money.m); //12.8 shallow copy
        System.out.println("===========");

        System.out.println(person.age);
        System.out.println(person2.age);
    }
    public static void main1(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.age = 99;
        // clone a person: If an object calls a clone(), the clone() needs to be overridden
        Person person2 = (Person)person.clone();
        System.out.println(person2); // person2.age = 99;
        System.out.println("==========================");

        person2.age = 199;
        System.out.println(person); // 99
        System.out.println(person2); // 199
    }
}
