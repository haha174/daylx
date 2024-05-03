package middle.red.combination_sum;

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res =new ArrayList<>();
        dfs(candidates,target,new ArrayList<>(),res,0);
        return res;
    }

    private void dfs(int[] candidates,  int target, List<Integer> tempList, List<List<Integer>> res,int curIndex) {
        if (target==0){
            res.add(new ArrayList<>(tempList));
        }
        for (int i=0;i<candidates.length;i++){
            if (target<0){
                break;
            }
            if (i<curIndex){
                continue;
            }
            tempList.add(candidates[i]);
            dfs(candidates,target-candidates[i],tempList,res,i);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] data={2,3,6,7};
        System.out.println(new Solution().combinationSum(data,7));
    }


}