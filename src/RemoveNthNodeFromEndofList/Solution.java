package RemoveNthNodeFromEndofList;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null ) {
            return head;
        }
        ListNode faster = head;
        ListNode slower = head;
        for (int i = 0; i < n; i++) {
            faster = faster.next;
            if (faster == null) {
                if(i==n-1){
                    return head.next;
                }else{
                    return head;
                }
            }
        }
        while (faster.next != null) {
            faster = faster.next;
            slower = slower.next;
        }
        slower.next = slower.next.next;
        return head;
    }
}