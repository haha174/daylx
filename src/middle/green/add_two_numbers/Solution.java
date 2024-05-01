package middle.green.add_two_numbers;

import common.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        int r = 0;
        while (l1 != null & l2 != null) {
            int num = l1.val + l2.val + r;
            r = num / 10;
            head.next = new ListNode(num % 10);;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remain = null;
        if (l1 != null) {
            remain = l1;
        } else {
            remain=l2;
        }
        if (remain!=null){
            while (remain!=null) {
                int num = remain.val + r;
                r = num / 10;
                head.next = new ListNode(num % 10);
                head = head.next;
                remain = remain.next;
            }
        }
        if (r>0){
            head.next = new ListNode(r);
            head = head.next;
        }

        return result.next;
    }
}