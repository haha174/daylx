package before.search_in_rotated_sorted_array_ii;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
class Solution {
    public boolean search(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            if (target==nums[i]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] data={2,5,6,0,0,1,2};
        System.out.println(new Solution().search(data,0));
    }
}