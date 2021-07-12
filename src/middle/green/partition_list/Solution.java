package middle.green.partition_list;

import common.ListNode;

class Solution {
    public static ListNode partition(ListNode head, int x) {
        ListNode listNode = new ListNode(0);
        ListNode largeThan = listNode;
        ListNode res = new ListNode(0);
        ListNode lessThan = res;
        while (head != null) {
            if (head.val < x) {
                lessThan.next = head;
                lessThan = lessThan.next;
            } else {
                largeThan.next = head;
                largeThan = largeThan.next;
            }
            head = head.next;
        }
        largeThan.next = null;
        lessThan.next = listNode.next;
        return res.next;
    }
}
