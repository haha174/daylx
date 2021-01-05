package before.rotate_list;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null ||head.next ==null){
            return head;
        }
        int length = 1;
        ListNode headCopy1 = head;
        while (headCopy1.next != null) {
            headCopy1 = headCopy1.next;
            length++;
        }
        ListNode headCopy2=head;
        int realK = k % length;
        for (int i=0;i<length-realK-1;i++){
            headCopy2=headCopy2.next;
        }
        headCopy1.next=head;
        head=headCopy2.next;
        headCopy2.next=null;
        return  head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        root.next = node1;
        node1.next = node2;

        new Solution().rotateRight(root, 4);
    }
}