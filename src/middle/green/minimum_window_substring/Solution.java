package middle.green.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        int min = Integer.MAX_VALUE;
        int head = 0;
        int count = 0;
        int start = 0;
        int end = 0;
        for (char c : t.toCharArray()) {
            map[c]++;
            count++;
        }
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) {
                count--;
            }

            while (count == 0) {
                if (end - start < min) {
                    min = end - (start);
                    head = start;
                }
                if (map[s.charAt(start++)]++ == 0) {
                    count++;
                }
            }
        }
        return s.substring(head, head + min);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}