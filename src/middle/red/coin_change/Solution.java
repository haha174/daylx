package middle.red.coin_change;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] dp=new int[amount+1];
        for (int i=1;i<=amount;i++){
            int min=amount+1;
            for (int j=0;j<coins.length ;j++){
                if (coins[j]<=i){
                    min= Math.min(min,dp[i-coins[j]]);
                }
            }
            dp[i]=min+1;
        }
        return dp[amount]>amount?-1:dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {474,83,404,3};
        int rem = 264;
        System.out.println(new Solution().coinChange(coins, rem));
    }
}
