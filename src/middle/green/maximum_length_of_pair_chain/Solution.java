package middle.green.maximum_length_of_pair_chain;

import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        int[] dp=new int[pairs.length];
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int result=0;
        for (int i=1;i<pairs.length;i++){
            for (int j=0;j<i;j++){
                if (pairs[i][0]>pairs[j][1]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
                result=Math.max(result,dp[i]);
            }
        }
        return result+1;
    }

    public static void main(String[] args) {
        int[][] pairs={{1,2}, {2,3}, {3,4}};
        System.out.println(new Solution().findLongestChain(pairs));
    }
}
