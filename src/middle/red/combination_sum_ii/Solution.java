package middle.red.combination_sum_ii;

import java.util.*;
class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), 0, 0, candidates, target);
        return res;
    }

    private void backtrack(List<Integer> tmp, int cur, int index, int[] candidates, int target){
        if(cur > target) return;
        if(cur == target){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i - 1])
                continue;
            tmp.add(candidates[i]);
            backtrack(tmp, cur + candidates[i], i + 1, candidates, target);
            tmp.remove(tmp.size() - 1);
        }
    }
}
