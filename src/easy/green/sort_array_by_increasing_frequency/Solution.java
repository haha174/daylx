package easy.green.sort_array_by_increasing_frequency;

import java.util.Arrays;

class Solution {
    public int[] frequencySort(int[] nums) {
        int[] cnts = new int[201];
        for (int n : nums){
            cnts[n + 100] ++;
        }
        for (int i = 0; i < nums.length; i ++){
            nums[i] = 10000 * cnts[nums[i] + 100] - nums[i] + 100;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i ++){
            nums[i] = 100 - nums[i] % 10000 ;
        }

        return nums;
    }
}
