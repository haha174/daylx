package contains_duplicate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 */
class Solution {
//    public boolean containsDuplicate(int[] nums) {
//        Set<Integer> deSet=new HashSet<>();
//        for (int i=0;i<nums.length;i++){
//            if (deSet.contains(nums[i])){
//                return true;
//            }else {
//                deSet.add(nums[i]);
//            }
//        }
//        return false;
//    }


    public boolean containsDuplicate(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            max = Math.max( max, num);
            min = Math.min(min, num);
        }
        boolean buckets[] = new boolean[max-min+1];
        for(int num:nums){
            if(buckets[num-min] == true){
                return true;
            } else {
                buckets[num-min] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(new Solution().containsDuplicate(nums));
    }
}