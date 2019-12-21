package minimum_window_substring;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * 通过数组的加减 求出最后的一个字母
 */
public class Solution {
    public String minWindow(String s, String t) {

        int[] map = new int[128];

        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int counter = t.length(), begin = 0, end = 0, min = Integer.MAX_VALUE, head = 0;

        while (end < s.length()) {
            // map[] > 0 说明该字符在T中出现，counter-- 表示对应的字符被包含在了窗口，
            // counter--, 如果s中的字符没有在T中出现，则map[]中对应的字符-1后变为负值
            if (map[s.charAt(end++)]-- > 0) {
                counter--; // in t
            }

            while (counter == 0) { // valid

                if (end - begin < min) {
                    min = end - (head = begin);
                }

                if (map[s.charAt(begin++)]++ == 0) {
                    counter++;

                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("EADOBECODCBANC","ABC"));
        //System.out.println(new Solution().minWindow("EADOBECODCOD","ABC"));
        ;
    }
}

    