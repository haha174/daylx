package easy.green.reverse_string_ii;

import java.util.Locale;

/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *  
 * <p>
 * 提示：
 * <p>
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
//
//    public String reverseStr(String s, int k) {
//        int t_cycle = s.length() / k;
//        int c_c = 0;
//        StringBuilder sb = new StringBuilder();
//        char[] sArray = s.toCharArray();
//        int c_cycle = 0;
//        while (c_cycle <= t_cycle) {
//            for (int i =Math.min( k * c_cycle + k - 1, sArray.length-1); i >= k * c_cycle; i--) {
//                sb.append(sArray[i]);
//            }
//            for (int i = k * c_cycle + k; i < 2 * k + k * c_cycle && i < sArray.length; i++) {
//                sb.append(sArray[i]);
//            }
//            c_cycle += 2;
//        }
//        return sb.toString();
//    }
public String reverseStr(String s, int k) {
    char[] chars = s.toCharArray();
    int start = 0;
    while(start<s.length()){
        int reverseEnd = Math.min(start+k-1,s.length()-1);
        reverse(chars,start,reverseEnd);
        start+=2*k;
    }
    return new String(chars);
}
    private void reverse(char[] chars,int start, int end){
        while(start<end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("a", 2));
    }
}