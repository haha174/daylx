package before.intersection_of_two_arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *https://leetcode.com/problems/intersection-of-two-arrays/
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 *
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(num->set.contains(num)).toArray();
    }
}