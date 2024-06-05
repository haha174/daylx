package middle.green.top_k_frequent_elements;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result=new int[k];
        Map<Integer,Integer> map=new HashMap<>();
       for (int i:nums){
           map.put(i,map.getOrDefault(i,0)+1);
       }
        Queue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
       for (Map.Entry<Integer,Integer> entry:map.entrySet()){
           if (queue.size()<k){
               queue.offer(new int[]{entry.getKey(),entry.getValue()});
           }else if( entry.getValue()>queue.peek()[1]){
               queue.poll();
               queue.offer(new int[]{entry.getKey(),entry.getValue()});
           }

       }
       int index=0;
       while (!queue.isEmpty()){
           result[index++]=queue.poll()[0];
       }
       return result;
    }

    public static void main(String[] args) {
        int[] data={4,1,-1,2,-1,2,3};
        int[] result=new Solution().topKFrequent(data,2);
        System.out.println();
    }
}
