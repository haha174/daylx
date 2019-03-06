package combination_sum;
import java.util.*;
public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);//先排序
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0 || candidates[0] > target) {//特殊情况处理
            return result;
        }
        List<Integer> tmp = new ArrayList<>();
        getSubSet(result, tmp, 0, target, candidates);//最开始从最小元素开始，差值是target
        return result;
    }

    public static void getSubSet(List<List<Integer>> res, List<Integer> tmp, int index, int remain, int[] nums) {

        for (int i = index; i < nums.length; i++) {
            if (remain - nums[i] < 0) {//也就是遍历到的元素，比target大，所以停止递归
                return;
            } else if (remain - nums[i] == 0) {
                List<Integer> r = new ArrayList<>(tmp);
                r.add(nums[i]);
                res.add(r);//加入到结果集，退出本次递归
                return;
            } else {
                if (i > index && nums[i] == nums[i - 1]) {//要求i大于基准索引，如果该i索引和上一个相等，那就跳过
                    continue;//这个不处理，就是在res.add(r)增加list contains判断，否则输出结果有重复结果集
                }
                tmp.add(nums[i]);//将本元素加入带待定结果集中
                //index=i+1,索引后移，而且差值更新
                getSubSet(res, tmp, i , remain - nums[i], nums);
                tmp.remove(tmp.size() - 1);
                index=index+1;
            }
        }
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        for (List<Integer> a : combinationSum(candidates, target)) {
            System.out.println(a.toString());
        }
    }

}