package middle.green.longest_consecutive_sequence;

import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length<1){
            return 0;
        }
        Arrays.sort(nums);
        int result=1;
        int tmp=1;

        for (int i=1;i<nums.length;i++){
           if (nums[i]==nums[i-1]){
               continue;
           } else if (nums[i]==nums[i-1]+1){
                tmp++;
            }else {
                result=Math.max(tmp,result);
                tmp=1;
            }
        }
        return Math.max(tmp,result);
    }



    public static void main(String[] args) {
        int[] arr={1,2,0,1};
        System.out.println(new Solution().longestConsecutive(arr));
    }
}