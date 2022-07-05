import java.util.*;

/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-26
 * @description: List interface <- ArrayList
 *
 * serializable 序列化：把一个对象，转变成字符串， json, Gson, 后端把数据给前端
 * 结合源代码看这些方法
 */
// 自己实现ArrayList的代码

class MyArrayList<E> {
    private Object[] elementData;
    private int usedSize; // 有效的数据个数，还未分配内存

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE-8;

    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArrayList(int capacity) {
        // 对参数进行判断
        if (capacity > 0) {
            this.elementData = new Object[capacity];
        } else if (capacity == 0) {
            this.elementData = new Object[0];
        } else {
            throw new IllegalArgumentException("Capacity can't be negative.");
        }
    }

    private void ensureCapacityInternal(int minCapacity) {
        // 1. 计算出需要的容量
        int capacity = calculateCapacity(elementData, minCapacity);
        // 2. 拿着计算出的容量，去看，满了扩容。空的，会分配10的内存
        ensureExplicitCapacity(capacity);
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        // elementData还没有分配内存
        if(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(10, minCapacity);
        }
        return minCapacity; // 已经分配了内存，返回+1后的值。
    }

    private void ensureExplicitCapacity(int minCapacity) {
        // overflow-conscious code
        // 进不去if loop，数组没有放满。
        if (minCapacity - elementData.length > 0)
            // 扩容
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 1.5倍扩容
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            // 说明需要的容量非常大
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }
    public boolean add(E e) {
        // 确定一个真正的容量，预测->扩容，把检查顺序表空和满和扩容都放在了一起
        // check the current capacity to see if e can be added to the ArrayList
        ensureCapacityInternal(usedSize+1);
        elementData[usedSize++] = e;
        return true;
    }

    public void add(int index, E e) {
        // 1 对index的合法性，进行判断
        rangeCheckForAdd(index);
        // 2 确定真正的容量
        ensureCapacityInternal(usedSize + 1);
        // 3 向后挪数据
        copy(index,e);
        usedSize++;
    }

    private void copy(int index,E e) {
        for (int i = usedSize-1; i >= index; i--) {
            elementData[i+1] = elementData[i];
        }
        elementData[index] = e;
    }
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index 位置不合法");
    }

    /*
    * 获取顺序表的size
    */
    public int size() {
        return this.usedSize;
    }
}

public class TestDemo2 {

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("dfd");
        list.add("qwew");
        list.add("dfw");
        list.add("pwj");
        list.add("oei");
        list.add(4,"champion");
        System.out.println("hdho");
    }

    public static void main6(String[] args) {
        // 如果ArrayList调用，不带参数的构造方法，那么顺序表的大小是0.当第一次add的时候，整个顺序表才变为10.
        // 当这10个放满了，会1.5倍扩容。
        ArrayList<String> list1 = new ArrayList<>();// Initial size is 0 in default
        list1.add("haha!"); //当第一次存放数据元素的时候，顺序表被分配大小为10

        // 如果调用的是给定容量的构造方法，那么顺序表的大小，就是给定的容量。当元素放满了，还是会1.5倍扩容。
        ArrayList<String> list2 = new ArrayList<>(10);

    }

    public static void main5(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        // common methods used in ArrayList
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("g");
        list2.add("f");
        System.out.println(list2);
        // sublist
        List<String> sub = list2.subList(1,3); // [1,3) 截取的内存地址，直接给到了sub

        System.out.println(list2.contains("c"));
        System.out.println(list2.indexOf("c"));

        String ret2 = list2.get(2);
        String ret3 = list2.set(2, "o");
        System.out.println(ret2);

        //list2.clear();
        //System.out.println(list2);

/*        String str = list2.remove(0);
        System.out.println(str);
        System.out.println(list2);*/

        // boolean ret = list2.remove("a");




/*        list2.add(0,"gaobo"); // [gaobo, a, b, c]
        System.out.println(list2);

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("This is test1");
        list3.add("This is test2");
        list2.addAll(list3);
        System.out.println(list2);*/ // 把list作为整个元素，添加到另外一个list里面。[gaobo, a, b, c, This is a test list]
    }

    // Java底层的code，是这么写add()
/*    public void add(int index, String element) {
        rangeCheckForAdd(index);

        ensureCapacityInternal(); // Increments modCount!
        System.arraycopy(elementData, index, elementData, index+1, size-index);
        elementData[index] = element;
        size++;
    }*/

    public static void main2(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("everyone");
        list2.add("!");

        // No add() in Iterator. add() is in ListIterator
        ListIterator<String> it2 = list2.listIterator();
        while (it2.hasNext()) {
            String ret = it2.next();
            if (ret.equals("hello")) {
                it2.add("gaobo"); // add "gaobo" behind "hello", depending on iterator position
            } else {
                System.out.print(ret + " ");
            }
        }
        System.out.println("\n=====\n" + list2);
    }
    public static void main1(String[] args) {
        // 3种构造方法
        List<String> list = new ArrayList<>(10); // 更加通用的写法
        // 帮助文档或者，Ctrl+点击类名，再Alt+7

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("everyone");
        list2.add("!");
        System.out.println(list2);
        System.out.println("===============");

        Iterator<String> itr = list2.iterator();
        while (itr.hasNext()) {
            String ret = itr.next();
            if(ret.equals("hello")) {
                // iterator remove():https://blog.csdn.net/idesvo/article/details/26558073
                itr.remove();
            } else {
                System.out.print(ret + " ");
            }
        }

        /*for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i)+ " ");
        }
        System.out.println();
        System.out.println("================");
        for (String s: list2) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("===使用迭代器打印===");
        // 使用迭代器打印, itr指向第一个元素的前面一个位置
        Iterator<String> itr = list2.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        System.out.println("===使用迭代器List相关打印===");
        ListIterator<String> itr2 = list2.listIterator();
        while(itr2.hasNext()) {
            System.out.print(itr2.next() + " ");
        }
        System.out.println();
*/
        // 使用另外一个ArrayList对list3进行初始化
        ArrayList<String> list3 = new ArrayList<>(list2);

    }
}
