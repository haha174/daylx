package middle.green.palindrome_linked_list;

import common.ListNode;

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode headTmp=head;
        ListNode reverseList=reverseList(headTmp);
        while (head.next!=null){
            if (head.val!=reverseList.val){
                return false;
            }
            head=head.next;
            reverseList=reverseList.next;
        }
        return true;
    }

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
        new Solution().isPalindrome(root);
        System.out.println();
    }

}