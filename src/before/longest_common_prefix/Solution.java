package before.longest_common_prefix;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
class Solution {
    //    public String longestCommonPrefix(String[] strs) {
//        StringBuilder sb = new StringBuilder();
//        if (strs==null || strs.length==0){
//            return "";
//        }
//        boolean flag = true;
//        int count = 0;
//        while (flag) {
//            for (int i = 0; i < strs.length; i++) {
//                if (count >= strs[i].length() || strs[i].charAt(count) != strs[0].charAt(count)) {
//                    flag=false;
//                    break;
//                }
//            }
//            if (flag){
//                sb.append(strs[0].charAt(count));
//            }
//            count++;
//        }
//        return sb.toString();
//    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static void main(String[] args) {
        //String[] strs={"dog","racecar","car"};
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}