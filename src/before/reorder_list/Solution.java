package before.reorder_list;

import common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        Deque<ListNode> deque = new LinkedList<>();

        ListNode next = head.next;
        while (next != null) {
            deque.add(next);
            next = next.next;
        }

        while (!deque.isEmpty()) {
            head.next = deque.pollLast();
            head = head.next;

            if (!deque.isEmpty()) {
                head.next = deque.pollFirst();
                head = head.next;
            }
        }

        head.next = null;
    }


    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        new Solution().reorderList(l1);
        System.out.println(l1);
    }

}