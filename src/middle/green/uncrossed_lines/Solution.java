package middle.green.uncrossed_lines;

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        for (int i=1;i<=nums1.length;i++){
            for (int j=1;j<=nums2.length;j++){
                if (nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }

    public static void main(String[] args) {
        int[] num1={1,3,7,1,7,5};
        int[] num2={1,9,2,5,1};
        System.out.println(new Solution().maxUncrossedLines(num1,num2));

    }
}