package easy.green.special_array_with_x_elements_greater_than_or_equal_x;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i=nums.length-1;i>=0;i--){
            int start=i-1>=0?nums[i-1]+1:0;
            if (nums.length-i>=start && nums.length-i<=nums[i]){
                return nums.length-i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data={0,4,3,0,4};
        System.out.println(new Solution().specialArray(data));
    }
}