package remove_duplicates_from_sorted_list_ii;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        return deleteDuplicates(head, Integer.MAX_VALUE);
    }

    private ListNode deleteDuplicates(ListNode head,int lastVal) {
        if (head == null) {
            return null;
        }
        // 处第非第一次遇到重复数字
        if (head.val == lastVal) {
            return deleteDuplicates(head.next, head.val);
        }

        if (head.next == null) {
            return head;
        }
        // 处第第一次遇到重复数字
        if (head.val == head.next.val) {
            return deleteDuplicates(head.next.next,head.val);
        }

        head.next = deleteDuplicates(head.next,head.val);
        return head;
    }

    public static void main(String[] args) {
        ListNode root=new ListNode(1);
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
//        ListNode node3=new ListNode(3);
//        ListNode node4=new ListNode(3);
        root.next=node1;
        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
        ListNode result= new Solution().deleteDuplicates(root);
        System.out.println();
    }
}