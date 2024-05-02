package middle.green.largest_rectangle_in_histogram;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static int largestRectangleArea(int[] heights) {
        int[] heightn = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            heightn[i] = heights[i];
        }
//        //最后增加个高度为0的柱子，以便把单调栈里面的都弹出来
//        heightn[heights.length] = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxS = 0;
        for (int i = 0; i < heightn.length; i++) {
            //一直出栈，直到遇到最小的
            while (!stack.isEmpty() && heightn[i] < heightn[stack.peek()]) {
                int tmp = stack.pop();
                maxS = Math.max(maxS, (stack.isEmpty() ? i : (i - stack.peek() - 1)) * heights[tmp]);
            }
            stack.push(i);
        }
        return maxS;
    }
}