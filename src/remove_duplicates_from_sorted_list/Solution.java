package remove_duplicates_from_sorted_list;


/**
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node=head;
        while (node!=null){
            if (node.next!=null&&node.val==node.next.val){
                node.next=node.next.next;   
            }else {
                node=node.next;
            }
        }
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