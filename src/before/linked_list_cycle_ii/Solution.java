package before.linked_list_cycle_ii;

/**
 * 快慢指针均从head结点开始，fast一次走两步，low一次走一步；
 * 设head结点到环的入口距离为L，环的入口到相遇点的距离为x，环的周长为c。相遇时fast走了L+x+kc，low走了L+x。由fast走的距离是low的两倍可知 L=kc-x；
 * 让fast从head开始，每次走一步。当fast走到入口时，正好走了L步。所以low也走了L=kc-x步，可以发现走了kc-x步的low正好也走到了环的入口，所以当快慢指针再次相遇时，它们所指的结点便是环的入口结点。
 * ————————————————
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
*Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 *https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while(fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
                
            }
        }
        return null;
    }
}