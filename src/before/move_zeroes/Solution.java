package before.move_zeroes;


/**
 *
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int j=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[j]=nums[i];
                if (i!=j){
                    nums[i]=0;
                }
                j++;
            }
        }

//        for (int i=0;i<nums.length;i++){
//            if (nums[i]!=0){
//                int temp=nums[j];
//                nums[j]=nums[i];
//                nums[i]=temp;
//                j++;
//            }
//        }
    }

    public static void main(String[] args) {
        int[] nums={1,1,0,3,12};
        new Solution().moveZeroes(nums);
        System.out.println(nums);
    }
}