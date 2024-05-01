package middle.green.merge_k_sorted_lists;

import common.ListNode;

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result=new ListNode();
        ListNode head=result;
        while (list1!=null && list2 !=null){
            if (list1.val<list2.val){
                ListNode tmp=new ListNode(list1.val);
                list1=list1.next;
                head.next=tmp;
            }else {
                ListNode tmp=new ListNode(list2.val);
                list2=list2.next;
                head.next=tmp;
            }
            head=head.next;
        }
        if (list1!=null){
            while (list1!=null ){
                ListNode tmp=new ListNode(list1.val);
                list1=list1.next;
                head.next=tmp;
                head=head.next;
            }
        }
        if (list2!=null){
            while (list2!=null ){
                ListNode tmp=new ListNode(list2.val);
                list2=list2.next;
                head.next=tmp;
                head=head.next;
            }
        }
        return result.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0){
            return null;
        }
        ListNode head=lists[0];
        for (int i=1;i<lists.length;i++){
            head=mergeTwoLists(head,lists[i]);
        }
        return head;
    }
}