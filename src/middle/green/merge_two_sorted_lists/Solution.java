package middle.green.merge_two_sorted_lists;
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

//
//    class Solution {
//        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            if (l1 == null) {
//                return l2;
//            } else if (l2 == null) {
//                return l1;
//            } else if (l1.val < l2.val) {
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            } else {
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }
//        }
//    }

}