import java.util.Arrays;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2022/01/15
 * @description 自己实现Stack
 */
public class MyStack {
    public int[] elem;
    public int usedSize;

    public MyStack() {
        this.elem = new int[5]; // 满了可以扩容
    }

    public void push(int value) {
        // 判断数组是否满了
        if(isFull()) {
            //满了，则2倍扩容. 用Arrays.copyOf来copy原始数据，并长度增加为原来数组的两倍
            this.elem = Arrays.copyOf(elem, 2*this.elem.length);
        }
        this.elem[this.usedSize] = value;
        this.usedSize++;
    }

    public boolean isFull() {
        if(usedSize == elem.length) {
            return true;
        }
        return false;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Can't pop due to empty array.");
        }
        int lastElem = this.elem[usedSize - 1];
        usedSize--;
        return lastElem;
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Can't pop due to empty array.");
        }
        return this.elem[usedSize - 1];
    }
}


