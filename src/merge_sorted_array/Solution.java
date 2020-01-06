package merge_sorted_array;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1, j = n - 1;
        for (;k>=0;k--){
            if (j<0){
                nums1[k]=nums1[i];
                i--;
            }else if (i<0){
                nums1[k]=nums2[j];
                j--;
            }else if(nums1[i]<nums2[j]){
                nums1[k]=nums2[j];
                j--;
            }else {
                nums1[k]=nums1[i];
                i--;
            }
        }
    }

    public static void main(String[] args) {

    }
}