package middle.green.reverse_nodes_in_k_group;

import common.ListNode;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result=head;
        ListNode cur=head;
        int index=0;
        ListNode last=null;
        while (cur!=null){
            index++;
            if (index%k==0){
                ListNode next=cur.next;
                cur.next=null;
                ListNode tmp=  reverseList(head);
                if (index==k){
                    result =tmp;
                }else {
                    last.next=tmp;
                }
                while (tmp.next!=null){
                    tmp=tmp.next;
                }
                head=next;
                tmp.next=next;
                last=tmp;
                cur=next;
            }else {
                cur=cur.next;
            }
        }
        return result;
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
        ListNode result=new Solution().reverseKGroup(root,2);
        System.out.println();
    }
}