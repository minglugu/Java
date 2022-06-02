/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-10-31
 */
class Person {

}
class Student extends Person {

}
public class Test {

    public static void main(String[] args) {
        //1. Can't cast array
        /*Integer[] integers = {1,2,3,4};
        Object[]objects = (Object[])integers;*/
        /*Student[] students = new Student[3];
        Person[]people=students;*/

        /*Person[] students = new Person[3];
        Student[]people= (Student[])students;*/
    }

    public static void main1(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,1);
        myArrayList.add(1,2);
        myArrayList.add(2,3);
        myArrayList.add(3,4);
        myArrayList.display();
        //myArrayList.remove(29);
        System.out.println("==============");
        myArrayList.clear();
        myArrayList.display();

       /* System.out.println(myArrayList.contains(3));
        System.out.println(myArrayList.getPos(21));*/
    }
}