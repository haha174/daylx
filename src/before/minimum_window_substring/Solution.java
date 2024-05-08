package before.minimum_window_substring;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * 通过数组的加减 求出最后的一个字母
 */
public class Solution {
//    public String minWindow(String s, String t) {
//        int[] map = new int[128];
//        int start=-1;
//        int min=Integer.MAX_VALUE;
//        int count=0;
//        for (char c:t.toCharArray()){
//            map[c]++;
//            count++;
//        }
//        for (int i=0;i<s.length();i++){
//            if (map[s.charAt(i)]<=0){
//                continue;
//            }
//            int countC=count;
//            for (int j=i+t.length()-1;j< s.length();j++){
//                if (map[s.charAt(j)]>0 && (--countC>0) && (j-i+1)<min && eq(s,i,j,map) ){
//                    min=(j-i)+1;
//                    start=i;
//                }
//            }
//        }
//
//     return start<0?"":s.substring(start,start+min);
//    }
//
//    private boolean eq(String s,int start,int end,int[] map){
//        int[] copy = new int[128];
//        for (int i=start;i<=end;i++){
//            copy[s.charAt(i)]++;
//        }
//        for (int i=0;i<copy.length;i++){
//            if (copy[i]<map[i]){
//                return false;
//            }
//        }
//        return true;
//    }


    public String minWindow(String s, String t) {
        int[] map = new int[128];
        int min=Integer.MAX_VALUE;
        int head=0;
        int count=0;
        int start=0;
        int end=0;
        for (char c:t.toCharArray()){
            map[c]++;
            count++;
        }
        while (end<s.length()){
            if (map[s.charAt(end++)]-->0){
                count--;
            }
            if (count==0){

                while (count==0){
                    if (end-start<min){
                        min=end-(start);
                        head=start;
                    }

                    if (map[s.charAt(start++)]++ ==0){
                        count++;
                    }
                }

            }
        }
        return min==Integer.MAX_VALUE?"":s.substring(head,head+min);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("AABCODEBANC","ABC"));
        //System.out.println(new Solution().minWindow("EADOBECODCOD","ABC"));
        ;
    }
}

    