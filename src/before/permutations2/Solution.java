package before.permutations2;


/**
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */

import java.util.ArrayList;
import java.util.List;
//import java.util.HashSet;
//import java.util.Set;
//public class Solution {
//
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<List<Integer>> result = new ArrayList<>();
//        Set<List<Integer>> set=new HashSet<>();
//        if (nums == null || nums.length == 0) return res;
//        boolean[] visited = new boolean[nums.length];
//        permuteBacktrack(nums, visited, new ArrayList<>(), res);
//        for (List<Integer> list :res){
//            set.add(list);
//        }
//        for (List<Integer> list :set){
//            result.add(list);
//        }
//        return result;
//    }
//
//    private void permuteBacktrack(int[] nums, boolean[] visited, List<Integer> l, List<List<Integer>> res) {
//        if (l.size() == nums.length) {
//            res.add(new ArrayList<>(l));
//        }
//        else {
//            for (int i = 0; i < nums.length; i++) {
//                if (!visited[i]) {
//                    visited[i] = true;
//                    l.add(nums[i]);
//                    permuteBacktrack(nums, visited, l, res);
//                    l.remove(l.size()-1);
//                    visited[i] = false;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums={1,1,2};
//        System.out.println(new Solution().permuteUnique(nums));
//    }
//}

public class Solution {

    // 在这里进行的去重复 如果后面有相同的数字那么这一次就不用交换了  应为这种情况已经被考虑了

    public boolean shouldSwap(int[] nums, int index) {
        for (int i = index+1; i < nums.length; ++i) {
            if (nums[i] == nums[index])
                return false;
        }
        return true;
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permu(nums, 0, list);
        return list;
    }

    public void permu(int[] nums, int vidx, List<List<Integer>> list) {
        if (vidx == nums.length) {
            List<Integer> l = new ArrayList<>();
            for (int val : nums)
                l.add(val);
            list.add(l);
            return;
        }
        // 关键点在于如何取判断是否需要判断进行交换
        // 一个数 只会 和后面的数字交换 减少迭代次数
        for (int i = vidx; i < nums.length; ++i) {
            if (shouldSwap(nums, i)) {
                swap(nums, vidx, i);
                permu(nums, vidx + 1, list);
                swap(nums, vidx, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1,3,2};
        System.out.println(new Solution().permuteUnique(nums));
    }
}
