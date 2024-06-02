package middle.red.word_break;

import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        for(int i = 1; i < len + 1; i++){
            for(int j = i; j >= 0; j--){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String s="catsandog";
        List<String> wordDict=Arrays.asList("cat", "dog", "san", "and", "cat");
        System.out.println(new Solution().wordBreak(s,wordDict));
    }
}