package before.intersection_of_two_arrays_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result=new ArrayList<>();
        int index1=0;
        int index2=0;
        while (index1<nums1.length && index2<nums2.length){
            if (nums1[index1]==nums2[index2]){
                result.add(nums1[index1]);
                index2++;
                index1++;
            }else if (nums1[index1]>nums2[index2]){
                index2++;
            }else{
                index1++;
            }
        }
        int[]ans=new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i]=result.get(i);
        }
        return ans;
    }
}