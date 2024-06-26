package middle.green.perfect_squares;

class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        for (int i=2;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for (int j=1;j*j<=i;j++){
                min=Math.min(min,dp[i-j*j]);
            }
            dp[i]=min+1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}