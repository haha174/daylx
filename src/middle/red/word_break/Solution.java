package middle.red.word_break;

import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length(), maxw = 0;
        boolean[] dp = new boolean[len + 1]; 
        dp[0] = true;
        Set<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
            maxw = Math.max(maxw, str.length());
        }
        for(int i = 1; i < len + 1; i++){
            for(int j = i; j >= 0 && j >= i - maxw; j--){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String s="aaaacd";
        List<String> wordDict=new ArrayList<>();
        wordDict.add("cd");
        System.out.println(new Solution().wordBreak(s,wordDict));
    }
}