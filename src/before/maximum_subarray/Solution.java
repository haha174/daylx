package before.maximum_subarray;

class Solution {
    public int maxSubArray(int[] nums) {
            int maxNum=nums[0];
            int currentMaxNum=nums[0];
            for(int i=1;i<nums.length;i++){
                currentMaxNum=Math.max(currentMaxNum+nums[i],nums[i]);
                if(currentMaxNum>maxNum){
                    maxNum=currentMaxNum;
                }
            }
            return maxNum;
    }
    public static void main(String[] args) {
        int[] data={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(  data  ));
        ;
    }
}