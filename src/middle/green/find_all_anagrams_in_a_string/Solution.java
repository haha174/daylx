package middle.green.find_all_anagrams_in_a_string;

import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        char[] pR=p.toCharArray();
        Arrays.sort( pR);
        for (int i=0;i+pR.length<=s.length();i++){
             if (checkAnagrams(s.substring(i,i+pR.length),pR)){
                 result.add(i);
             }
        }
        return result;
    }
    public boolean checkAnagrams(String s, char[] pR){
        char[] sR=s.toCharArray();
        Arrays.sort( sR);
        for (int i=0;i<sR.length;i++){
            if (sR[i]!=pR[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams( "abab",  "ab"));
    }
}