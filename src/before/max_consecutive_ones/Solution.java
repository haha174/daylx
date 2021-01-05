package before.max_consecutive_ones;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 */
class Solution {
    //    public int findMaxConsecutiveOnes(int[] nums) {
//        if (nums==null || nums.length==0){
//            return 0;
//        }
//
//        int result=0;
//        int current=0;
//        int pre=nums[0];
//        for (int c:nums){
//            if (c==pre && c==1){
//                current++;
//            }else {
//                if (current>result){
//                    result=current;
//                }
//                pre=c;
//
//                current= pre==1?1:0;
//            }
//        }
//        if (current>result){
//            result=current;
//        }
//        return result;
//    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, count = 0;
        for (int num : nums)
            if (num == 0) {
                ans = Math.max(ans, count);
                count = 0;
            } else
                count++;
        ans = Math.max(ans, count);
        return ans;
    }
}