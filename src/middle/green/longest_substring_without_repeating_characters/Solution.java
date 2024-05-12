package middle.green.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        int min=0;
        int start=-1;
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i))>start){
                start=map.get(s.charAt(i));
            }else {
                min=Math.max(i-start, min);
            }
            map.put(s.charAt(i),i);
        }

        return map.size()==s.length()? s.length():min  ;
    }

//
//
//    public int lengthOfLongestSubstring(String s) {
//        int result=0;
//        char[] sc=s.toCharArray();
//        for (int i=0;i<sc.length;i++){
//            result=Math.max(result, getTempResult(i,sc))  ;
//        }
//        return result;
//    }
//
//    private int getTempResult(int left,char[] s){
//        int result=0;
//        char[] ex=new char[256];
//        for (int i=left;i<s.length;i++){
//            if (ex[s[i]]>0){
//                break;
//            }
//            ex[s[i]]=1;
//            result++;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("tmmzuxt"));
    }
}