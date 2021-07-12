package middle.red.best_time_to_buy_and_sell_stock_iv;

class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2 * k + 1];
        for(int i = 1;i < 2 * k + 1;i += 2){
            dp[0][i] = -prices[0];
        }
        for(int i = 1;i < n;i++){
            for(int j = 0;j < 2 * k - 1;j += 2){
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1],dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2],dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[n - 1][2 * k];
    }

    public static void main(String[] args) {
        int k = 2, prices[] = {3,2,6,5,0,3};
        System.out.println(new Solution().maxProfit(k,prices));
    }
}
