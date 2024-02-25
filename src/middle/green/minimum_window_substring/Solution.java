package middle.green.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {

        int[] map = new int[128];

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int counter = t.length(), begin = 0, end = 0, min = Integer.MAX_VALUE, head = 0;

        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) {
                counter--; // in t
            }

            while (counter == 0) { // valid

                if (end - begin < min) {
                    min = end - (head = begin);
                }

                if (map[s.charAt(begin++)]++ == 0) {
                    counter++; // make it invalid
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("AADOBECODEBANC","ABC"));
    }
}