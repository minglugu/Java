class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
    }
}
public class MyQueue {
    public Node head;
    public Node last;

    /**
     * add to the last
     * @param val
     */
    public void offer(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
            last = node;
        }else {
            last.next = node;
            last = last.next;
        }
    }

    /**
     * pop
     * @return
     */
    public int poll() {
        if(isEmpty()) {
            throw new RuntimeException("Empty queue.");
        }
        int oldVal = head.val;
        this.head = head.next;
        return oldVal;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("Empty queue.");
        }
        return head.val;
    }
}