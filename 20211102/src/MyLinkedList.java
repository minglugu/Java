import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: 12629
 * Date: 2021/11/02
 * Time: 19:00
 * Description:
 */

//ListNode代表一个节点
class ListNode {
    public int val;
    public ListNode next;//null

    public ListNode(int val) {
        this.val = val;
    }
}
public class MyLinkedList {

    public ListNode head;//链表的头引用

    public void createList() {
        ListNode listNode1 = new ListNode(12);
        ListNode listNode2 = new ListNode(23);
        ListNode listNode3 = new ListNode(34);
        ListNode listNode4 = new ListNode(45);
        ListNode listNode5 = new ListNode(56);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        //listNode5.next = null;
        this.head = listNode1;
    }

    public void display() {
        //this.head.next != null
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 从指定头节点开始进行打印
     * @param newHead
     */
    public void display2(ListNode newHead) {
        //this.head.next != null
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
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

    //得到单链表的长度
    public int size(){
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }


    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        node.next = this.head;
        this.head = node;
        /*if(this.head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }*/
    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
        }else {
            ListNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            //cur.next == null;
            cur.next = node;
        }
    }

    /**
     * 找到index-1位置的节点的地址
     * @param index
     * @return
     */
    public ListNode findIndex(int index) {
        ListNode cur = this.head;
        while (index-1 != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
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
        ListNode cur = findIndex(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
    }

    /**
     * 找到 要删除的关键字的前驱
     * @param key
     * @return
     */
    public ListNode searchPerv(int key) {
        ListNode cur = this.head;
        while (cur.next != null) {
            if(cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head == null) {
            System.out.println("单链表为空，不能删除！");
            return;
        }
        if(this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        ListNode cur = searchPerv(key);
        if(cur == null) {
            System.out.println("没有你要删除的节点！");
            return;
        }
        ListNode del = cur.next;
        cur.next = del.next;
    }

    //删除所有值为key的节点
    public ListNode removeAllKey(int key){
        if(this.head == null) return null;
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while (cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        //最后处理头
        if(this.head.val == key) {
            this.head = this.head.next;
        }
        return this.head;
    }


    public void clear(){
        //this.head == null
        while (this.head != null) {
            ListNode curNext = head.next;
            this.head.next = null;
            this.head = curNext;
        }
    }

    public ListNode reverseList() {
        if(this.head == null) {
            return null;
        }
        ListNode cur = this.head;
        ListNode prev = null;

        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }

    public ListNode middleNode() {
        if(head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            if(fast == null) {
                return slow;
            }
            slow = slow.next;
        }
        return slow;
    }

    public ListNode findKthToTail(int k) {
        if(k <= 0 || head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k-1 != 0) {
            fast = fast.next;
            if(fast == null) {
                return null;
            }
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode partition(int x) {
        // write code here
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = head;
        while (cur != null) {
            if(cur.val < x) {
                //1、第一次
                if(bs == null) {
                    bs = cur;
                    be = cur;
                }else {
                    //2、不是第一次  尾插
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if(as == null) {
                    as = cur;
                    ae = cur;
                }else {
                    //2、不是第一次
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        //预防第一个段为空
        if(bs == null) {
            return as;
        }
        be.next = as;
        //预防第2个段当中的数据，最后一个节点不是空的
        if(as != null) {
            ae.next = null;
        }
        return bs;
    }

    public ListNode deleteDuplication() {
        ListNode cur = head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (cur != null) {
            if(cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                //多走一步
                cur = cur.next;
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        //防止最后一个节点的值也是重复的
        tmp.next = null;
        return newHead.next;
    }

    public boolean chkPalindrome(ListNode A) {
        // write code here
        if(head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow走到了中间位置-》反转

        ListNode cur = slow.next;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //反转完成
        while(head != slow) {
            if(head.val != slow.val) {
                return false;
            }
            if(head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }


    public boolean hasCycle() {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return false;
        }
        return true;
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public void createLoop() {
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head.next.next;
    }


}