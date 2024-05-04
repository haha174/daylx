package middle.red.longest_palindromic_substring;
import java.util.*;

class Solution {
//    public String longestPalindrome(String s) {
//        int strLen = s.length();
//        int left = 0;
//        int right = 0;
//        int len = 1;
//        int maxStart = 0;
//        int maxLen = 0;
//        for (int i = 0; i < strLen; i++) {
//            left = i - 1;
//            right = i + 1;
//            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
//                len++;
//                left--;
//            }
//            while (right < strLen && s.charAt(right) == s.charAt(i)) {
//                len++;
//                right++;
//            }
//            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
//                len = len + 2;
//                left--;
//                right++;
//            }
//            if (len > maxLen) {
//                maxLen = len;
//                maxStart = left;
//            }
//            len = 1;
//        }
//        return s.substring(maxStart + 1, maxStart + maxLen + 1);
//    }

    int left=0;
    int max=0;
    public String longestPalindrome(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        dp[0][0]=true;


        for (int i=0;i<s.length()-1;i++){
            valid(dp,s,i,i);
            valid(dp,s,i,i+1);
        }
        return s.substring(left,left+max+1);
    }

    private void valid(boolean dp[][],String s,int left,int right){
        while (left>=0 && right< dp.length && right>=left&& s.charAt(left)==s.charAt(right)){
            dp[left][right]=true;
            if (right-left>max){
                max=right-left;
                this.left=left;
            }
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
    }
}

