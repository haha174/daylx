package easy.green.rotate_string;

/**
 * 给定两个字符串, A 和 B。
 * <p>
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 * <p>
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 * 注意：
 * <p>
 * A 和 B 长度不超过 100。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean rotateString(String A, String B) {
        if (A==null && B==null )return true;
        if (A == null || B == null) return false;
        if (A.length()==B.length() && A.length()==0) return true;
        if (A.length() != B.length()) return false;
        char[] Aa = A.toCharArray();
        char[] Bb = B.toCharArray();
        for (int i = 0; i < Aa.length; i++) {
            if (Aa[i] == Bb[0]) {
                int cA = i;
                int cB = 0;
                while ( cB < Bb.length && Aa[cA % Aa.length] == Bb[cB] ) {
                    cA++;
                    cB++;
                }
                if (cB == Bb.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rotateString("abcde","cdeab"));
    }
}