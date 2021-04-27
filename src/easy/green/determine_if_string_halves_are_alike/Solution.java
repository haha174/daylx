package easy.green.determine_if_string_halves_are_alike;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean halvesAreAlike(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        int len = s.length();
        Set<Character> set = new HashSet<>();
        //set = Set.('a','e','i','o','u','A','E','I','O','U');
        int cnt1 = 0, cnt2 = 0;
        int i = 0,j = len - 1;
        while(i < j){
            if(set.contains(s.charAt(i))){
                cnt1++;
            }
            if(set.contains(s.charAt(j))){
                cnt2++;
            }
            i++;
            j--;
        }
        return cnt2 == cnt1;
    }
}
