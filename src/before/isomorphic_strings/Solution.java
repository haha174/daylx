package before.isomorphic_strings;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 *
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {

//        for (int i = 0; i < s.length(); i++) {
//            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) return false;
//        }
//        return true;
        char[] map = new char[128];
        boolean[] used = new boolean[128];

        char[] chs1 = s.toCharArray();
        char[] chs2 = t.toCharArray();

        if(chs1.length != chs2.length) return false;

        for(int i=chs1.length-1 ; i>=0 ; i--){
            if(map[chs1[i]] == chs2[i]) {
                continue;
            }

            if(map[chs1[i]] == '\0' && !used[chs2[i]]){
                map[chs1[i]] = chs2[i];
                used[chs2[i]] = true;
            }
            else {
                return false;
            }
        }
        return true;


    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("paper","asdfe"));
    }
}