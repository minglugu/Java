/**
 * Created with IntelliJ IDEA.
 * Date: 2022/1/16
 * Description: circular queue
 */
public class MyCircularQueue {

    public int[] elem;
    public int front;//队头下标
    public int rear;//队尾下标
    public MyCircularQueue(int k) {
        this.elem = new int[k];
    }

    /**
     * 入队
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        if(isFull()) return false;

        this.elem[rear] = value;
        //rear++;
        rear = (rear+1)% elem.length;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        front = (front+1)% elem.length;
        return true;
    }

    /**
     * 得到队头元素
     * @return
     */
    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return elem[front];
    }

    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        int index = -1;
        if(rear == 0) {
            index = elem.length-1;
        }else {
            index = rear-1;
        }
        return elem[index];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        //rear的下一个是front
        if( (this.rear+1) % elem.length == front) {
            return true;
        }
        return false;
    }
}
Comment ( 0 )