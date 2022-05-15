package middle.red.coin_change;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;

        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min=Integer.MAX_VALUE;
       for (int coin:coins){
           int res=coinChange(coins,rem-coin,count);
           if (res >= 0 &&res<min){
               min=res+1;
           }
       }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10};
        int rem = 48;
        System.out.println(new Solution().coinChange(coins, rem));
    }
}
