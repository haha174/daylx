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

//    public boolean wordBreak(String s, List<String> wordDict) {
//       return wordBreak(s,0,wordDict);
//    }
//
//    public boolean wordBreak(String s, int start,List<String> wordDict) {
//        if (start>=s.length()){
//            return true;
//        }
//        for (int i=0;i<wordDict.size();i++){
//            if ( wordDict.get(i).length()+start<=s.length() && s.substring(start,wordDict.get(i).length()+start).equals(wordDict.get(i)) && wordBreak(s,start+wordDict.get(i).length(),wordDict)){
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        String s="catsandog";
        List<String> wordDict=Arrays.asList("cat", "dog", "san", "and", "cat");
//        wordDict.add("apple");
//        wordDict.add("pen");
        System.out.println(new Solution().wordBreak(s,wordDict));
    }
}