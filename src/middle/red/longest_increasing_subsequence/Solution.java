package middle.red.longest_increasing_subsequence;

class Solution {
//    public int lengthOfLIS(int[] nums) {
//       int[] dp=new int[nums.length];
//       int max=1;
//       for (int i=0;i<nums.length;i++){
//           dp[i]=1;
//       }
//       for (int i=1;i<nums.length;i++){
//           for (int j=i;j>=0;j--){
//                if (nums[i]>nums[j]){
//                    dp[i]=Math.max(dp[i],dp[j]+1);
//                    max=Math.max(max,dp[i]);
//                }
//           }
//       }
//       return max;
//    }


    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int max=1;
        for (int i=0;i<nums.length;i++){
           dp[i]=1;
       }
        for (int i=1;i<nums.length;i++){
            int tmpMax=0;
            for (int j=i-1;j>=0;j--){
                if (nums[i]>nums[j]){
                    tmpMax=Math.max(tmpMax,dp[j]);
                }
            }
            dp[i]=tmpMax+1;
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] data={10,9,2,5,3,7,101,18};
        System.out.println(new Solution().lengthOfLIS(data));
    }
}