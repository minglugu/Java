/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-10-29
 * @description Class, object, & time complexity
 * this.data: current object's attribute
 * this.func(): current object's function
 * this(): current object's constructor in the first line
 */
class Person {
    //attributes -> object
    private String name;
    private int age=19;
    //static variable -> class variable ->方法区（A.class, static int count: 静态成员变量，Person.class）
    //Static variables can be accessed by calling with ClassName.VariableName  . It does not depend on object.
    public static int count;//0

    // final: constance, can't be modified, belongs to object
    public final int SIZE = 10;
    // static: COUNT is in method area
    public static final int COUNT = 2;

    // order: static code, instance code, constructor
    {
        this.age = 99;
        System.out.println("实例代码块！");
    }

    // static code will be executed first, and only run once.
    // It doesn't depend on object.
    // can be used for static variable
    static {
        count = 99;
        System.out.println("静态代码块！");
    }

    public Person() {
        //this("haha");
        //this("gaobo",18);//调用带有1个参数的构造方法
        System.out.println("Person()：：不带参数的构造方法");
    }

    public Person(String name) {
        this.name = name;
        System.out.println("Person(String)：：带一个String类型参数的构造方法");
    }

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person(String,int)：：带2个String,int类型参数的构造方法");
    }

    public String getName() {
        //this("haha");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
       /* int a = 10;
        a = 9;
        a = 8;*/
        //static int size = 0; error
        System.out.println(name+"正在吃饭！");
    }

    public void print() {
        //this.eat();
        // call static method in a method
        //staticFunc();
        System.out.println("Name: "+name+" age: "+age);
    }

    // methods in class
    public static void staticFunc() {
        //this.age = 10;error
        //static int size = 10;error
        //print();error,need object to call print()
        /*Person person = new Person();
        person.print();*/
        /*The double colon (::) operator, also known as method reference operator in Java,
        is used to call a method by referring to it with the help of its class directly.
        Syntax: <Class name>::<method name>
        Reference URL: https://www.geeksforgeeks.org/double-colon-operator-in-java/ */
        System.out.println("static::func()");
    }

    /*public String toString() {
        return "姓名："+name+" 年龄："+age;
    }*/

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestDemo {

    public static void main6(String[] args) {
        new Person().eat();
        new Person().print();
        System.out.println(new Person());
        System.out.println("==============");
        Person person1 = new Person();
        person1.eat();
        person1.print();
        System.out.println(person1);
    }

    public static void main5(String[] args) {

        System.out.println(Person.count);// 用class name调用
    }

    public static void main4(String[] args) {
        Person person1 = new Person();
        System.out.println("==========");
        Person person2 = new Person();
    }


    public static void main3(String[] args) {
        Person person = new Person();
        System.out.println(person);
    }

    public static void main2(String[] args) {
        Person person = new Person();
        System.out.println("===========");
        Person person2 = new Person("bit");
        System.out.println("===========");
        Person person3 = new Person("bit",19);
    }


    public static void main1(String[] args) {
        Person person = new Person();
        //person.name = "bit";
        person.setName("bit");
        person.setAge(10);
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }

    /*Person person = new Person();

    public static void main8(String[] args) {
        TestDemo testDemo = new TestDemo();

    }

    public static void main7(String[] args) {
        // person object can only refer to one object, in this case, it refers to the last object
        Person person = new Person();
        person = new Person();
        person = new Person();
        person = new Person();
        person = new Person();
        person = new Person();
    }

    public static void func() {

    }

    public void func2() {

    }

    public static void main6(String[] args) {
        func(); // static method, direct call
        TestDemo testDemo = new TestDemo();
        testDemo.func2(); // use an object to call this method
    }

    public static void main5(String[] args) {
        func();
        TestDemo testDemo = new TestDemo();
        testDemo.func2();
    }

    public static void main4(String[] args) {
        //Person.staticFunc();
        Person p = new Person();
        p.eat();
        p.print();
    }

    public static void main2(String[] args) {
        Person person1 = new Person();
        person1.age++;
        System.out.println(person1.age);//1

        System.out.println("==========================");

        Person person2 = new Person();
        person2.age++;
        System.out.println(person2.age);//1
    }

    public static void main3(String[] args) {
        *//*Person person1 = new Person();
        person1.count++;*//*
        Person.count++;
        System.out.println(Person.count);//1

        System.out.println("==========================");

        *//*Person person2 = new Person();
        person2.count++;*//*
        Person.count++;
        System.out.println(Person.count);//1->2
    }

    public static void main1(String[] args) {
        Person person = new Person();
        person.name = "bit";
        person.age = 99;
        System.out.println(person.name);
        System.out.println(person.age);
        person.eat();
        person.print();
        System.out.println("==============");
        Person person1 = new Person();
        person1.name = "gaobo";
        person1.age = 10;
        System.out.println(person1.name);
        System.out.println(person1.age);
    }*/
}