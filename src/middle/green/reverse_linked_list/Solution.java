package middle.green.reverse_linked_list;

import common.ListNode;

import java.util.Stack;

class Solution {
//        public ListNode reverseList(ListNode head) {
//            ListNode prev = null;
//            ListNode curr = head;
//            while (curr != null) {
//                ListNode next = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = next;
//            }
//            return prev;
//        }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }



    public static void main(String[] args) {
        ListNode root=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(5);
        root.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode result=new Solution().reverseList(root);
        System.out.println();
    }
}