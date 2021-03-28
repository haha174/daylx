package easy.green.last_stone_weight;

import java.util.Arrays;

class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length==1){
            return stones[stones.length-1];
        }
       boolean flag=true;
        while (flag){
            Arrays.sort(stones);
            if (stones[stones.length-2]==0){
                return stones[stones.length-1];
            }
            stones[stones.length-1]=stones[stones.length-1]-stones[stones.length-2];
            stones[stones.length-2]=0;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] stones={2,7,4,1,8,1};
        System.out.println(new Solution().lastStoneWeight(stones));
    }
}