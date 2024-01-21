package middle.green.longest_arithmetic_subsequence_of_given_difference;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] pairs={1,5,7,8,5,3,4,2,1};
        System.out.println(new Solution().longestSubsequence(pairs,2));
    }
}