package easy.green.longest_nice_substring;

import java.util.HashSet;

class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        if (n < 2) {
            return "";
        }
        String ans = "";
        // len 滑动窗口长度
        for (int len = 2; len <= n; len++) {
            // i 滑动窗口起始位置
            for (int i = 0; i + len - 1 < n; i++) {
                String substring = s.substring(i, i + len);
                if (substring.length() > ans.length() && isNicety(substring)) {
                    ans = substring;
                }
            }
        }
        return ans;
    }

    private boolean isNicety(String s) {
        HashSet<Character> upperSet = new HashSet<>();
        HashSet<Character> lowerSet = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperSet.add(ch);
            } else {
                lowerSet.add(Character.toUpperCase(ch));
            }
        }
        if (upperSet.size() != lowerSet.size()) {
            return false;
        }
        upperSet.removeAll(lowerSet);
        return upperSet.size() == 0;
    }
}
