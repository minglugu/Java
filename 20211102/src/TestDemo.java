/**
 * @author Minglu Gu
 * @version 1.0
 * @since 2021-11-02
 */

public class TestDemo {

    public static ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (headA != null && headB != null) {
            if(headA.val < headB.val) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if(headA != null) {
            tmp.next = headA;
        }
        if(headB != null) {
            tmp.next = headB;
        }
        return newHead.next;
    }

    public static void createCut(ListNode headA, ListNode headB){
        headA.next.next = headB.next.next;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode pl = headA;
        ListNode ps = headB;
        int lenA = 0;
        int lenB = 0;
        while (pl != null) {
            lenA++;
            pl = pl.next;
        }
        //pl==null
        pl = headA;
        while (ps != null) {
            lenB++;
            ps = ps.next;
        }
        //ps==null
        ps = headB;
        int len = lenA-lenB;//差值步
        if(len < 0) {
            pl = headB;
            ps = headA;
            len = lenB-lenA;
        }
        //1、pl永远指向了最长的链表   ps 永远指向了最短的链表  2、求到了差值len步

        //pl走差值len步
        while (len != 0) {
            pl = pl.next;
            len--;
        }
        //同时走 直到相遇
        while (pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        return pl;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(23);
        myLinkedList.addLast(34);
        myLinkedList.addLast(45);
        myLinkedList.addLast(56);
        //myLinkedList.createLoop();
        System.out.println(myLinkedList.hasCycle());
    }

    public static void main3(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(23);
        myLinkedList.addLast(34);
        myLinkedList.addLast(45);




        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.addLast(13);
        myLinkedList2.addLast(24);
        myLinkedList2.addLast(30);

        //createCut(myLinkedList.head,myLinkedList2.head);
        /*try {
            ListNode ret = getIntersectionNode(myLinkedList.head,myLinkedList2.head);
            System.out.println(ret.val);
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("没有相交的节点" +
                    "!");
        }*/


        /*ListNode ret = mergeTwoLists(myLinkedList.head,myLinkedList2.head);

        myLinkedList.display2(ret);*/

    }


    public static void main2(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        //myLinkedList.createList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(23);
        myLinkedList.addLast(34);
        myLinkedList.addLast(45);
        myLinkedList.display();

        ListNode ret = myLinkedList.findKthToTail(2);
        System.out.println(ret.val);

        //myLinkedList.clear();
        //System.out.println("ffafsaf");
    }
    public static void main1(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        //myLinkedList.createList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(23);
        myLinkedList.addLast(34);
        myLinkedList.addLast(45);
        myLinkedList.addLast(45);
        myLinkedList.addFirst(156);
        myLinkedList.addIndex(31,99);
        myLinkedList.display();
        boolean flg = myLinkedList.contains(56);
        System.out.println(flg);
        System.out.println(myLinkedList.size());
    }
}