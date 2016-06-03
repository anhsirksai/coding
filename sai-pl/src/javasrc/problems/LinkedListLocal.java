package javasrc.problems;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by INSRSAI1 on 5/31/2016.
 */
public class LinkedListLocal {

    ArrayList<ListNode> nodes;
    ArrayList<ListNode> getNodes() {return nodes;}

    static ListNode head;

    class ListNode<T> {
        T val;
        ListNode next;

        ListNode(T v){
            val = v;
            next = null;
        }
    }

    void detectAndRemoveLoop(ListNode node){
        ListNode slow = null, fast = node;

        while(slow != null && fast != null & fast.next != null){
            if (slow == fast) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast == slow) {
            slow = node;
            while (slow != fast.next){
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    public LinkedListLocal filList(){
        LinkedListLocal list = new LinkedListLocal();
        list.head = new ListNode(50);
        list.head.next = new ListNode(20);
        list.head.next.next = new ListNode(15);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(10);

        return list;
    }

    public static void main (String [] args) {
        LinkedListLocal ll = new LinkedListLocal();
        ll.filList();

        ll.detectAndRemoveLoop(ll.getNodes().get(0));

        for(ListNode l = ll.getNodes().get(0); l!=null; l = l.next) {
            System.out.println(l.val);

        }
    }

}
