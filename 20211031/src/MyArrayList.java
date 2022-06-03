import java.util.Arrays;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-10-31
 * @description ArrayList CRUD methods
 */

public class MyArrayList {

    public int[] elem;
    public int usedSize;// elements in the arraylist

    public MyArrayList() {
        this.elem = new int[10];
    }

    // print each element
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    // get the size of elements
    public int size() {
        return this.usedSize;
    }

    // insert a new element in the index called pos
    public void add(int pos, int data) {
        if(pos < 0 || pos > usedSize) {
            System.out.println("pos is invalid.");
            return;
        }
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
        //3、
        for (int i = this.usedSize-1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    // check if an element is in the arraylist
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // check if the index of an element in the arraylist. If not found, return -1.
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // return the element of a certain index in the arraylist
    public int getPos(int pos) {
        if(pos < 0 || pos >= this.usedSize) {
            System.out.println("pos 位置不合法");
            return -1;//所以 这里说明一下，业务上的处理，这里不考虑. Could throw an exception
        }
        if(isEmpty()) {
            System.out.println("顺序表为空！");
            return -1;
        }
        return this.elem[pos];
    }

    public boolean isEmpty() {
        return this.usedSize==0;
    }

    // set or update the value at the index
    public void setPos(int pos, int value) {
        if(pos < 0 || pos >= this.usedSize) {
            System.out.println("pos is invalid.");
            return;
        }
        if(isEmpty()) {
            System.out.println("The array is empty.");
            return;
        }
        this.elem[pos] = value;
    }

    //delete the first found element, the next element will be moved to the
    public void remove(int toRemove) {
        if(isEmpty()) {
            System.out.println("Empty arraylist");
            return;
        }
        int index = search(toRemove);
        if(index == -1) {
            System.out.println("Element does not exist.");
            return;
        }
        // i < usedSize - 1, because remove 1 element, the size will be usedSize-1
        for (int i = index; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
        //this.elem[usedSize] = null; if the data type is reference type in the arraylist.
    }
    // empty the arraylist
    public void clear() {
        this.usedSize = 0;
        // for reference type
        /*for (int i = 0; i < usedSize; i++) {
            this.elem[i] = null;
        }
        this.usedSize = 0;
        */
    }
}