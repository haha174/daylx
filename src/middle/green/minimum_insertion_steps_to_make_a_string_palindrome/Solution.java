package middle.green.minimum_insertion_steps_to_make_a_string_palindrome;

/**
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 *
 * 请你返回让 s 成为回文串的 最少操作次数 。
 *
 * 「回文串」是正读和反读都相同的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 * 示例 2：
 *
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 * 示例 3：
 *
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
 */
class Solution {
    public int minInsertions(String s) {
        char[] c=s.toCharArray();
        int[][] dp=new int[c.length+1][c.length+1];
        for (int i=1;i<=c.length;i++){
            for (int j=1;j<=c.length;j++){
                if (c[i-1]==c[c.length-j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return c.length-dp[c.length][c.length];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minInsertions("mbadm"));
    }
}