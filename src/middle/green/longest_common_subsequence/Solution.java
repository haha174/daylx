package middle.green.longest_common_subsequence;

/**
 * https://leetcode.cn/problems/longest-common-subsequence/solutions/696763/zui-chang-gong-gong-zi-xu-lie-by-leetcod-y7u0/?envType=study-plan-v2&envId=dynamic-programming
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
       for (int i=1;i<=m;i++){
           char t1=text1.charAt(i-1);
           for (int j=1;j<=n;j++){
               char t2=text2.charAt(j-1);
                if (t1==t2){
                    dp[i][j]=  dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=  Math.max(dp[i-1][j],dp[i][j-1]);
                }
           }
       }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1="abcde";
        String str2="ace";
        System.out.println(new Solution().longestCommonSubsequence(str1,str2));
    }
}

