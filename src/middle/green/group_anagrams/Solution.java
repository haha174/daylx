package middle.green.group_anagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> stringStringMap = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String nStr=new String(array);
            if (!stringStringMap.containsKey(nStr)){
                stringStringMap.put(nStr,new ArrayList<>());
            }
            stringStringMap.get(nStr).add(str);
        }
        return new ArrayList<>(stringStringMap.values());
    }

    public static void main(String[] args) {
        String[] strs= {"eat","tea","tan","ate","nat","bat"};
        System.out.println(new Solution().groupAnagrams(strs));
    }
}