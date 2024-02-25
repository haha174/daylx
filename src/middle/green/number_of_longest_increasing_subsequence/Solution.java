package middle.green.number_of_longest_increasing_subsequence;

/**
 * https://leetcode.cn/problems/number-of-longest-increasing-subsequence/description/?envType=study-plan-v2&envId=dynamic-programming
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 * <p>
 * 注意 这个数列必须是 严格 递增的。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 */
class Solution {
        public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxLen = 0, ans = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j]; // 重置计数
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i]; // 重置计数
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,3,5,4,7,2};
        System.out.println(new Solution().findNumberOfLIS(nums));
    }
}