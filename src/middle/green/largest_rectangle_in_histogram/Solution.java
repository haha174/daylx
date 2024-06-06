package middle.green.largest_rectangle_in_histogram;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static int largestRectangleArea(int[] heights) {
        int maxS=0;
        int[] heightn = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            heightn[i] = heights[i];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heightn.length; i++) {
            int current=heightn[i];
           if (!stack.isEmpty() && heightn[stack.peek()]>current){
               while (!stack.isEmpty() && heightn[stack.peek()]>current){
                   int lastIndex= stack.pop();
                   maxS=Math.max(maxS,(stack.isEmpty()?i:i-stack.peek()-1)*heightn[lastIndex]);
               }
           }
           stack.push(i);
        }
        return maxS;
    }

    public static void main(String[] args) {
        int[] data={2,1,2};
        System.out.println(new Solution().largestRectangleArea(data));
    }
}