package easy.green.na_ying_bi;

class Solution {
    public int minCount(int[] coins) {
        int count = 0;
        for(int coin: coins){
            //右移一位相当于除以2，和1按位与相当于除2取余
            count += (coin >> 1) + (coin & 1);
        }
        return count;
    }
}

