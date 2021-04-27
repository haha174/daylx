package easy.green._4xy4Wx;

import java.util.Arrays;

class Solution {
    public int purchasePlans(int[] nums, int target) {
        int mod = 1_000_000_007;
        int ans = 0;
        // 首先对整体进行排序
        Arrays.sort(nums);
        // 双指针，left 从前往后找，right 从后往前
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 如果当前左右之和大于了目标值，说明偏大了，就把右指针往左移动
            if (nums[left] + nums[right] > target) right--;
            else {
                // 否则的话，说明找到了合适的，需要把两者中间的元素个数都累加起来
                ans += right - left;
                // 然后再向右移动左指针
                left++;
            }
            ans %= mod;
        }
        return ans % mod;
    }
}
