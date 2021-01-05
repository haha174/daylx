package before.swap_nodes_in_pairs;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
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

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode root=new ListNode(0);
        ListNode result=root;
        while (head!=null){
            ListNode next=head.next;
            if (next==null){
                root.next=head;
            }else{
                head.next=next.next;
                root.next=next;
                next.next=head;
                root=head;
            }
            head=head.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode root=new ListNode(1);
//        ListNode node1=new ListNode(2);
//        ListNode node2=new ListNode(3);
//        ListNode node3=new ListNode(4);
//        root.next=node1;
//        node1.next=node2;
//        node2.next=node3;
        new Solution().swapPairs(root);
    }
}