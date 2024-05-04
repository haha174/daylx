package middle.red.maximum_product_subarray;
class Solution {
    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int t1=maxF * nums[i];
            int t2=minF * nums[i];
            maxF = Math.max(t1,Math.max(t2,nums[i]));
            minF = Math.min(t1, Math.min(t2,nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data={-2,-3,7};
        System.out.println(new Solution().maxProduct(data));
    }
}

