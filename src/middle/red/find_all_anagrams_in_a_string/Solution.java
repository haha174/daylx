package middle.red.find_all_anagrams_in_a_string;

import java.util.*;
class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        int n = s.length();

        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) pMap.put(c, pMap.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        int flag = 0;
        List<Integer> res = new ArrayList<>();
        while (right < n) {

            char c = s.charAt(right);;
            if (pMap.containsKey(c)) {

                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (windowMap.get(c).equals(pMap.get(c))) {

                    flag++;
                }
            }

            while (right - left + 1 == p.length()) {

                if (flag == pMap.size()) res.add(left);

                char c1 = s.charAt(left);
                left++;
                if (pMap.containsKey(c1)) {

                    if (windowMap.get(c1).equals(pMap.get(c1))) {

                        flag--;
                    }
                    windowMap.put(c1, windowMap.getOrDefault(c1, 0) - 1);
                }
            }
            right++;
        }
        return res;
    }
}

