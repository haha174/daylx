package before.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set)
 * Note: The solution set must not contain duplicate subsets.
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        generateCombinations(result,new ArrayList<>(),nums,0);
        return result;
    }

    public void generateCombinations(List<List<Integer>> result,List<Integer> current,int[] nums,int start){
        result.add(new ArrayList<>(current));
        for (int i=start;i<nums.length;i++){
            if (!current.contains(nums[i]) ){
                current.add(nums[i]);
                generateCombinations(result, current,nums,i+1);
                current.remove(current.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(new Solution().subsets(nums));
    }
}