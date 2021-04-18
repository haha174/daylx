package easy.green.minimum_subsequence_in_non_increasing_order;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int t1 = 0;
            int t2 = 0;
            for (int j = i; j < nums.length; j++) {
                t1 += nums[j];
            }
            for (int j = 0; j < i; j++) {
                t2 += nums[j];
            }
            result.add(nums[i]);
            if (t1 > t2) {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data={4,4,7,6,7};
        new Solution().minSubsequence(data);
    }
}