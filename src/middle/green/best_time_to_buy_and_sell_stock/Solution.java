package middle.green.best_time_to_buy_and_sell_stock;

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n<=1) return 0;
        int [][] dp=new int[n][3];
      //  0.不持股且当天没卖出,定义其最大收益dp[i][0];
       // 1.持股,定义其最大收益dp[i][1]；
       //  2.不持股且当天卖出了，定义其最大收益dp[i][2]；
        dp[0][0]=0;
        dp[0][1]=-1*prices[0];
        dp[0][2]=0;
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]=dp[i-1][1]+prices[i];
        }
        return Math.max(dp[n-1][0],dp[n-1][2]);
    }

    public static void main(String[] args) {
        int[] data=  {7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(data));
    }
}
