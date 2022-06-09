/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-08
 * @Description doubly linked list
 */

class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {

    public ListNode head;//指向双向链表的头节点
    //public ListNode head = new ListNode(-1);//指向双向链表的头节点
    public ListNode last;//指向的是尾巴节点

    public void display() {
        //和单链表的打印方式是一样的
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //得到单链表的长度
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
            this.last = node;
        }else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
            this.last = node;
        }else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    public ListNode searchIndex (int index) {
        ListNode cur = this.head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        ListNode node = new ListNode(data);
        if(index < 0 || index > size()) {
            System.out.println("index位置不合法！");
            return;
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }
        ListNode cur = searchIndex(index);
        node.next = cur.prev.next; // this is also correct: node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                if(cur == head) {
                    head = head.next;
                    if(head != null) {
                        head.prev = null;
                    }else {
                        last = null;
                    }
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        //中间位置
                        cur.next.prev = cur.prev;
                    }else {
                        last = last.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        last = null;
                    }
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        //中间位置
                        cur.next.prev = cur.prev;
                    } else {
                        last = last.prev;
                    }
                }
                //return;
            }
            cur = cur.next;
        }
    }

    //jps   jmap -histo:live XXXX > c:\\bit.txt
    public void clear() {
        while (head != null) {
            ListNode curNext = head.next;
            head.next = null;
            head.prev = null;
            head = curNext;
        }
        last = null;
    }
}
