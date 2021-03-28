package easy.green.matrix_cells_in_distance_order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        int[][] res=new int[R*C][2];
        int maxLength=0;
        for (int i=0;i<R;i++){
            for (int j=0;j<C;j++){
                int currentLength=Math.abs(i-r0)+Math.abs(j-c0);
                if (currentLength>maxLength){
                    maxLength=currentLength;
                }
                if (map.containsKey(currentLength)){
                    map.get(currentLength).add(i);
                    map.get(currentLength).add(j);
                }else {
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    map.put(currentLength,list);
                }
            }
        }
        int count=0;
        for (int i=0;i<=maxLength;i++){
            if (map.containsKey(i)){
                List<Integer> list=map.get(i);
                for (int j=0;j<list.size();j+=2){
                    res[count][0]=list.get(j);
                    res[count][1]=list.get(j+1);
                    count++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int R = 1, C = 2, r0 = 0, c0 = 0;
        System.out.println(new Solution().allCellsDistOrder(R,C,r0,c0));
    }
}