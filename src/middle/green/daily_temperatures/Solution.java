package middle.green.daily_temperatures;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] result=new int[temperatures.length];
            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i=0;i<temperatures.length;i++){
                while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                    int t=stack.pop();
                    result[t]=i-t;
                }
                stack.push(i);
            }
            return result;
        }

    public static void main(String[] args) {
        int[] data={73,74,75,71,69,72,76,73};
        System.out.println(new Solution().dailyTemperatures(data));
    }
}