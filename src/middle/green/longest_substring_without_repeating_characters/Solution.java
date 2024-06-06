package middle.green.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        int result=0;
        int start=-1;
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (map.containsKey(c) && start<=map.get(c)){
                start=map.get(c);
            }
            result=Math.max(result,i-start);
            map.put(c,i);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}