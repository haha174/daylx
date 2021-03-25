package easy.red.di_string_match;

/**
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *  
 *
 * 示例 1：
 *
 * 输入："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 *
 * 输入："III"
 * 输出：[0,1,2,3]
 * 示例 3：
 *
 * 输入："DDI"
 * 输出：[3,2,0,1]
 *  
 *
 * 提示：
 *
 * 1 <= S.length <= 10000
 * S 只包含字符 "I" 或 "D"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] diStringMatch(String S) {
        int[] result=new int[S.length()+1];
        int left=0;
        int right=S.length();
        char[] attr=S.toCharArray();
        for (int i=0;i<attr.length;i++){
            if (attr[i]=='I'){
                result[i]=left++;
            }else {
                result[i]=right--;
            }
        }
        result[attr.length]=right;
        return result;
    }
}