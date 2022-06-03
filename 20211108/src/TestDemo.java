/**
 * @author Minglu Gu
 * @version 1.0
 * @since yyyy-mm-dd
 */
class Test {
    public String toString() {
        System.out.print("aaa");
        return "bbb";
    }
}
public class TestDemo {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.display();
        System.out.println("=======");
        //myLinkedList.removeAllKey(2);
        myLinkedList.addIndex(3,99);
        myLinkedList.display();
    }


    public static void main2(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(111111);
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        //System.out.println(myLinkedList.size());
        myLinkedList.display();//3 2 1 1111111
        //System.out.println(myLinkedList.contains(1));
        myLinkedList.addLast(11);
        myLinkedList.addLast(12);
        myLinkedList.display();//3 2 1 111111 11 12

    }

    public static void main1(String[] args) {
        //Test test = new Test();
        //System.out.println(test);
        System.out.println(new Test());
        int a = 10;
        System.out.println(a);
        System.out.println(10);
    }
}