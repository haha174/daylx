package valid_anagram;

/**
 *
 * https://leetcode.com/problems/valid-anagram/
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s==null && t==null){
            return true;
        }
        if (s!=null && t!=null &&s.length()==t.length() ){
            int[] validate=new int[26];
            char[] sA=s.toCharArray();
            char[] tA=t.toCharArray();
            for (int i=0;i<sA.length;i++){
                validate[sA[i]-97]++;
            }
            for (int i=0;i<tA.length;i++){
                validate[tA[i]-97]--;
                if (validate[tA[i]-97]<0){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println('a'+1);
        System.out.println(new Solution().isAnagram("car","rac"));
        ;
    }
}