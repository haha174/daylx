package middle.green.delete_and_earn;

class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prepre=nums[0];
        int pre=Math.max(prepre,nums[1]);
        int cur=Math.max(prepre,pre);

        for (int i=2;i<nums.length;i++){
            cur=Math.max(prepre+nums[i],pre);
            prepre=pre;
            pre=cur;
        }
        return cur;

    }

}