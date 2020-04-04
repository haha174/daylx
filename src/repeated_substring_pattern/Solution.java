package repeated_substring_pattern;

/**
 *
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 *
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        int l = s.length();
        for(int i=0; i<primes.length; i++){
            int pl = primes[i];
            if(pl>l/2) break;
            if(l%pl != 0) continue;

            int size = l/pl;
            if(repeat(s, l, size)) return true;

        }
        return false;
    }

    boolean repeat(String s, int l, int size) {
        for (int j = l; j > size; j -= size) {
            if (!s.substring(j - size - size, j - size).equals(s.substring(j - size, j))) {
                return false;
            }
        }

        return true;
    }
}