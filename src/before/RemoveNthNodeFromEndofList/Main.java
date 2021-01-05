package before.RemoveNthNodeFromEndofList;

public class Main {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        root.next=node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = new Solution().removeNthFromEnd(node1, 5);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
}
