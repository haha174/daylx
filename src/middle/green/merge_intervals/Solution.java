package middle.green.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               if (o1[0]==o2[0]){
                   return o1[1]-o2[1];
               }else {
                   return o1[0]-o2[0];
               }
           }
       });
       List<int[]> result=new ArrayList<>();
       int[] pre=intervals[0];
       for (int i=1;i<intervals.length;i++){
           int[] tmp=intervals[i];
           if (tmp[0]<=pre[1]){
               pre[1]=Math.max( pre[1],tmp[1]);
           }else {
               result.add(pre);
               pre=tmp;
           }
       }
       if (pre!=null){
           result.add(pre);
       }
       return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18},{2,3}};
        int[][] result =  new Solution().merge(intervals);
        System.out.println(result);
    }
}