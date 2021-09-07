package middle.red.longest_increasing_subsequence;

class Solution {
    public int lengthOfLIS(int[] nums) {
       int[] dp=new int[nums.length];
       int max=1;
       for (int i=0;i<nums.length;i++){
           dp[i]=1;
       }
       for (int i=1;i<nums.length;i++){
           for (int j=i;j>=0;j--){
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    max=Math.max(max,dp[i]);
                }
           }
       }
       return max;
    }
    public static void main(String[] args) {
        int[] data={1,3,6,7,9,4,10,5,6};
        System.out.println(new Solution().lengthOfLIS(data));
    }
}