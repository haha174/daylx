package before.delete_node_in_a_linked_list;

/**
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Given linked list -- head = [4,5,1,9], which looks like following:
 *
 *
 *
 *https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 * Example 1:
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * Example 2:
 *
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 *
 */
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}


class Solution {
    public void deleteNode(ListNode node) {
        ListNode n = node;
        while(n.next.next!=null){
            n.val = n.next.val;
            n=n.next;
        }
        n.val = n.next.val;
        n.next=null;
    }
}