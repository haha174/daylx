package longest_palindrome;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

/**
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *a 97  A 65
 */
class Solution {
    public int longestPalindrome(String s) {
        if (s==null|| s.length()==0)
            return 0;
        int result=0;
        int[] al=new int[58];
        char[] sA=s.toCharArray();
        for (char a:sA){
            if (al[a-'A']>0){
                al[a-'A']--;
                result+=2;
            }else {
                al[a-'A']++;
            }
        }
        for(int i=0;i<al.length;i++){
            if (al[i]>0){
                return result+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("Azccccdd"));
    }
}