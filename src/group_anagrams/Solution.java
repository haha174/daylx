package group_anagrams;

import java.util.*;

/**
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (String str : strs) {
            char[] arr = new char[26];
            for (char c : str.toCharArray()) {
                arr[c - 'a'] += 1;
            }
            String cur = new String(arr);

            List<String> temp = map.getOrDefault(cur, new ArrayList<>());
            temp.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat"};
        new Solution().groupAnagrams(array);
    }
}