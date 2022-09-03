import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2022/1/16
 * Time: 8:23
 * Description: main method
 */
public class TestDemo {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());//1
        System.out.println(queue.poll());//1
        System.out.println(queue.poll());//2
        System.out.println(queue.poll());//3
        System.out.println(queue.poll());
    }

    public static void main2(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(2);
        System.out.println(queue.peek());//1
        System.out.println(queue.poll());//1
    }

    public static void main3(String[] args) {
        Deque<Integer> queue2 = new LinkedList<>();
        queue2.offerLast(1);//默认队尾入队的
        queue2.offerFirst(2);
        //2 1
        System.out.println(queue2.peekFirst());//2
        System.out.println(queue2.peekLast());//1
    }


    public static void main1(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> queue2 = new LinkedList<>();

        LinkedList<Integer> list = new LinkedList<>();

    }
}