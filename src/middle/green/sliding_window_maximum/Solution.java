package middle.green.sliding_window_maximum;

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result=new int[nums.length-k+1];
         Queue<int[]> queue=new PriorityQueue<int[]>(new Comparator<int[]>() {
             @Override
             public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o2[1]-o1[1]:o2[0]-o1[0];
             }
         });
         for (int i=0;i<k-1;i++){
             queue.add(new int[]{nums[i],i});
         }
         for (int i=k-1;i< nums.length;i++){
             queue.add(new int[]{nums[i],i});
             while (!queue.isEmpty() && i-queue.peek()[1]>=k){
                 queue.poll();
             }
             result[i-k+1]=queue.peek()[0];
         }
         return result;
    }

    public static void main(String[] args) {
        //1,3,-1,-3,2,5,3,6,7
        int[] data={1,-1};
        int[] result=  new Solution().maxSlidingWindow(data,1);
        System.out.println(result);
    }
}