package before.reverse_linked_list;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 Reverse a singly linked list.
 Example:
 Input: 1->2->3->4->5->NULL
 Output: 5->4->3->2->1->NULL
 */

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
      public ListNode reverseList(ListNode head) {
            ListNode pre=null;
            while (head!=null){
                  ListNode next=head.next;
                  head.next=pre;
                  pre=head;
                  head=next;
            }
            return pre;
      }

      public static void main(String[] args) {
            ListNode root=new ListNode(1);
            ListNode node1=new ListNode(2);
            ListNode node2=new ListNode(3);
            root.next=node1;
            node1.next=node2;
            new Solution().reverseList(root);
      }
}