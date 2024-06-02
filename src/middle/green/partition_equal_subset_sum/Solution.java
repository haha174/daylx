package middle.green.partition_equal_subset_sum;

class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return false;
            }
            int sum = 0, maxNum = 0;
            for (int num : nums) {
                sum += num;
                maxNum = Math.max(maxNum, num);
            }
            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            if (maxNum > target) {
                return false;
            }
            // return dfs( nums, target, 0);
            boolean[][] dp = new boolean[n][target + 1];
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }
            dp[0][nums[0]] = true;
            for (int i = 1; i < n; i++) {
                int num = nums[i];
                for (int j = 1; j <= target; j++) {
                    if (j >= num) {
                        dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n - 1][target];
        }


        // 超时 动态规划是一种减少计算的模式
//        private boolean dfs(int[] nums,int target,int index){
//            if (index>=nums.length){
//                return false;
//            }
//            if (nums[index]==target){
//                return true;
//            }
//            return dfs( nums, target-nums[index], index+1) || dfs( nums, target, index+1);
//        }

    public static void main(String[] args) {
        int[] data={3,3,3,4,5};
        System.out.println(new Solution().canPartition(data));
    }


}