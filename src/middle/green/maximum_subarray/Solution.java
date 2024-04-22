package middle.green.maximum_subarray;

class Solution {
//    public int maxSubArray(int[] nums) {
//        int result=Integer.MIN_VALUE;
//        for (int i=0;i<nums.length;i++){
//            int temp=0;
//            for (int j=i;j<nums.length;j++){
//                temp+=nums[j];
//                result=Math.max(result,temp);
//            }
//        }
//        return result;
//    }
//



//        public int maxSubArray(int[] nums) {
//            int pre = 0;
//            int res = nums[0];
//            for (int num : nums) {
//                pre = Math.max(pre + num, num);
//                res = Math.max(res, pre);
//            }
//            return res;
//        }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i] 表示：以 nums[i] 结尾的连续子数组的最大和
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        // 也可以在上面遍历的同时求出 res 的最大值，这里我们为了语义清晰分开写，大家可以自行选择
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

        public static void main(String[] args) {
        int[] data={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(data));
    }
}