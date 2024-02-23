package easy.green.longest_arithmetic_subsequence;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-arithmetic-subsequence/description/?envType=study-plan-v2&envId=dynamic-programming
 */
//class Solution {
//    public int longestArithSeqLength(int[] nums) {
//        int minv = Arrays.stream(nums).min().getAsInt();
//        int maxv = Arrays.stream(nums).max().getAsInt();
//        int diff = maxv - minv;
//        int ans = 1;
//        for (int d = -diff; d <= diff; ++d) {
//            int[] f = new int[maxv + 1];
//            Arrays.fill(f, -1);
//            for (int num : nums) {
//                int prev = num - d;
//                if (prev >= minv && prev <= maxv && f[prev] != -1) {
//                    f[num] = Math.max(f[num], f[prev] + 1);
//                    ans = Math.max(ans, f[num]);
//                }
//                f[num] = Math.max(f[num], 1);
//            }
//        }
//        return ans;
//    }
//}


//
//
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        // f[i][j] 表示以 nums[i] 结尾且公差为 j 的等差子序列的最大长度。
        // 省略初始化dp为1的过程，最后给 ans 加 1 即可
        int[][] dp = new int[n][1001];
        // 所有 dp[i][j] 的最大值
        int ans = 0;
        // 递推，nums[i] 为等差数列末尾项
        for (int i = 0; i < n; ++i) {
            // 枚举前一项 nums[j]
            for (int j = 0; j < i; ++j) {
                // 那么公差为 nums[i] - nums[j] + 500
                int d = nums[i] - nums[j] + 500;
                // 更新 dp[i][d]
                dp[i][d] = dp[j][d] + 1;
                // 更新 ans
                ans = Math.max(ans, dp[i][d]);
            }
        }
        // 返回时别忘记给 ans + 1
        return ans + 1;
    }
}