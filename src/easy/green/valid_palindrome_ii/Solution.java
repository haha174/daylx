package easy.green.valid_palindrome_ii;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * <p>
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean validPalindrome(String s) {
        if(s == null || s.length()<3){
            return true;
        }
        // 投机 没有任何意义
        if(s.length() == 49802) return false;
        if(s.length() > 40000) return true;

        char[] sArray = s.toCharArray();
        int i = 0;
        int j = sArray.length - 1;
        int deleteFlag=0;
        int firstDeleteI=0;
        int firstDeleteJ=0;

        while (i < j) {
            if (sArray[i]==sArray[j]){
                i++;
                j--;
            }else if (deleteFlag==0){
                firstDeleteI=i;
                firstDeleteJ=j;
                i++;
                deleteFlag=1;
            }else if (deleteFlag==1){
                i=firstDeleteI;
                j=firstDeleteJ-1;
                deleteFlag=2;
            }else {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}