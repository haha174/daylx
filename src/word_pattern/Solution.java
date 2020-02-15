package word_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/word-pattern/
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 *
 */

class Solution {
    public boolean wordPattern(String pattern, String str) {

        String[] words = str.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<Character, String>();

        for (int i = 0; i < pattern.length(); i++)  {
            if (!map.containsKey(pattern.charAt(i)))    {
                if (map.containsValue(words[i]))    {
                    return false;
                }
                map.put(pattern.charAt(i), words[i]);
            }
            else {
                if (!map.get(pattern.charAt(i)).equals(words[i]))   {
                    return false;
                }
            }
        }

        return true;

    }
    public static void main(String[] args) {
        new Solution().wordPattern("abba"
                ,"dog cat cat dog");
    }
}