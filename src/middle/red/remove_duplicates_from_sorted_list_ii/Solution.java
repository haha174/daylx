package middle.red.remove_duplicates_from_sorted_list_ii;

import common.ListNode;
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode dummy=new ListNode(0,head);
        ListNode cur=dummy;
        while (dummy.next!=null && dummy.next.next!=null ){
            if ( dummy.next.val==dummy.next.next.val){
                int duNum=dummy.next.val;
                while (dummy.next!=null && dummy.next.val==duNum){
                    dummy.next=dummy.next.next;
                }
            }else {
                dummy=dummy.next;
            }
        }
        return cur.next;
    }


    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(1);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(4);
        ListNode node7=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
//        node5.next=node6;
//        node6.next=node7;
        System.out.println(new Solution().deleteDuplicates(node1));
    }
}