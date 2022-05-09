package middle.green.di_string_match;

import java.util.Locale;

public class Solution {
    public int[] diStringMatch(String s) {
        int min=0,max=s.length();
        int index=0;
        int[] result=new int[s.length()+1];
        for (char i:s.toCharArray()){
            if(i=='D'){
                result[index++]=max--;
            }else {
                result[index++]=min++;
            }
        }
        result[index]=min;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().diStringMatch("IDID"));
    }
}