package before.palindrome_linked_list;


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        ListNode slow = head, fast = slow.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p1 = head;
        ListNode p2 = reverse(slow.next);
        while ( p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, temp;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode root=new ListNode(1);
        ListNode ndde1=new ListNode(1);
        ListNode ndde2=new ListNode(2);
        ListNode ndde3=new ListNode(1);
        root.next=ndde1;
        ndde1.next=ndde2;
        ndde2.next=ndde3;
        System.out.println(new Solution().isPalindrome(root));

    }
}