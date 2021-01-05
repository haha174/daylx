package before.reverse_nodes_in_k_group;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k<=1){
            return head;
        }
        ListNode result=new ListNode(0);
        ListNode resultTmp=result;
        while (head!=null){
            int i=1;
            ListNode root=head;
            ListNode rootTemp=root;
            head=head.next;
            for (;i<k && head!=null;i++){
                rootTemp.next=new ListNode(head.val);;
                rootTemp=rootTemp.next;
                head=head.next;
            }
            if (i==k){
                resultTmp.next=reverseList(root);
                for (i=0;i<k;i++){
                    resultTmp=resultTmp.next;
                }
            }else {
                resultTmp.next=root;
            }
        }
        return result.next;
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
        new Solution().reverseKGroup(root,2);
    }
}