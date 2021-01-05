package before.combination_sum;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        getSubSet(result,tmp,0,target,candidates);
        return result;
    }
    public static void getSubSet(List<List<Integer>> result,List<Integer> tmp,int index,int target,int[] candidates){
        for(int i=index;i<candidates.length;i++){
            if(target-candidates[i]<0){
                return;
            }else if(target-candidates[i]==0){
                List<Integer> r = new ArrayList<>(tmp);
                r.add(candidates[i]);
                result.add(r);
                return;
            }else{
                if(i>index && candidates[i]==candidates[i-1]||(index==i&&i>0&&candidates[i]==candidates[i-1])){
                    continue;
                }
                tmp.add(candidates[i]);
                getSubSet(result,tmp,i,target-candidates[i],candidates);
                tmp.remove(tmp.size()-1);
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 2,3, 6, 7};
        int target = 7;
        for (List<Integer> a : combinationSum(candidates, target)) {
            System.out.println(a.toString());
        }
    }
}
