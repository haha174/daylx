package before.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *https://leetcode.com/problems/3sum/
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
////        List<List<Integer>> result=new ArrayList<>();
////        Arrays.sort(nums);
////        for (int k=0;k<nums.length-1;k++){
////            if (k>0 && nums[k]==nums[k-1]){
////                continue;
////            }
////            for (int i=k+1,j=nums.length-1;i<j;){
////                if (nums[k]+nums[i]+nums[j]<0){
////                    i++;
////                }else if(nums[k]+nums[i]+nums[j]>0)  {
////                    j--;
////                }else {
////                    List<Integer> resultTmp=new ArrayList<>();
////                    resultTmp.add(nums[k]);
////                    resultTmp.add(nums[i]);
////                    resultTmp.add(nums[j]);
////                    result.add(resultTmp);
////                    i++;
////                    j--;
////                    while (i<j && nums[i]==nums[i-1]){
////                        i++;
////                    }
////                    while (i<j && nums[j]==nums[j+1]){
////                        j--;
////                    }
////                }
////            }
////        }
////        return result;
////}
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue)
                minValue = v;
            if (v > maxValue)
                maxValue = v;
            if (v > 0)
                posSize++;
            else if (v < 0)
                negSize++;
            else
                zeroSize++;
        }
        if (zeroSize >= 3)
            res.add(Arrays.asList(0, 0, 0));
        if (negSize == 0 || posSize == 0)
            return res;
        if (minValue * 2 + maxValue > 0)
            maxValue = -minValue * 2;
        else if (maxValue * 2 + minValue < 0)
            minValue = -maxValue * 2;

        // value counter
        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0)
                        poses[posSize++] = v;
                    else if (v < 0)
                        negs[negSize++] = v;
                }
            }
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int nv = negs[i];
            int minp = (-nv) >>> 1;
            while (basej < posSize && poses[basej] < minp)
                basej++;
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                int cv = 0 - nv - pv;
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1)
                            res.add(Arrays.asList(nv, nv, pv));
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1)
                            res.add(Arrays.asList(nv, pv, pv));
                    } else {
                        if (map[cv - minValue] > 0)
                            res.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv)
                    break;
            }
        }
        return res;
}

    public static void main(String[] args) {
        int[] nums={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> result=new Solution().threeSum(nums);
        System.out.println(result);
    }
}