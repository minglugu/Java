import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 2022/1/16
 * Description: data structure of stack and its methods
 */
public class MyStack {
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;

    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    public void push(int x) {
        if(!qu1.isEmpty()) {
            qu1.offer(x);
        }else if(!qu2.isEmpty()) {
            qu2.offer(x);
        }else{
            qu1.offer(x);
        }
    }

    public int pop() {
        if(empty()) return -1;

        if(!qu1.isEmpty()) {
            int size = qu1.size();
            for(int i = 0; i < size-1;i++) {
                int val = qu1.poll();
                qu2.offer(val);
            }
            return qu1.poll();
        }

        if(!qu2.isEmpty()) {
            int size = qu2.size();
            for(int i = 0; i < size-1;i++) {
                int val = qu2.poll();
                qu1.offer(val);
            }
            return qu2.poll();
        }
        return -1;
    }

    public int top() {
        if(empty()) return -1;

        if(!qu1.isEmpty()) {
            int val = -1;
            int size = qu1.size();
            for(int i = 0; i < size;i++) {
                val = qu1.poll();
                qu2.offer(val);
            }
            return val;
        }

        if(!qu2.isEmpty()) {
            int val = -1;
            int size = qu2.size();
            for(int i = 0; i < size;i++) {
                val = qu2.poll();
                qu1.offer(val);
            }
            return val;
        }
        return -1;
    }

    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
    }
}