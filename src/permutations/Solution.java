package permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        permuteBacktrack(nums, visited, new ArrayList<>(), res);
        return res;
    }

    private void permuteBacktrack(int[] nums, boolean[] visited, List<Integer> l, List<List<Integer>> res) {
        if (l.size() == nums.length) {
            res.add(new ArrayList<>(l));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    l.add(nums[i]);
                    permuteBacktrack(nums, visited, l, res);
                    l.remove(l.size()-1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        new Solution().permute(nums);
    }
}
