package easy.green.convert_binary_number_in_a_linked_list_to_integer;

import common.ListNode;

class Solution {
    public int getDecimalValue(ListNode head) {
        int num = 0;
        ListNode node = head;
        while(node != null){
            num = (num << 1) + node.val;//num << 1:有符号左移1位 相当于乘2
            node = node.next;
        }
        return num;
    }
}

