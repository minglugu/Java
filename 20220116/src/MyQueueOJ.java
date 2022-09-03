import java.util.Stack;

/**
 * User: 12629
 * Date: 2022/1/16
 * Time: 11:20
 */
public class MyQueueOJ {
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public MyQueueOJ() {
        stack1 =  new Stack<>();
        stack2 =  new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(empty()) return-1;
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if(empty()) return-1;
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}