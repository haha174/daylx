package middle.green.largest_rectangle_in_histogram;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static int largestRectangleArea(int[] heights) {
        int[] heightn = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            heightn[i] = heights[i];
        }
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

    public static void main(String[] args) {
        int[] data={2,1,5,6,2,2,2,3};
        System.out.println(new Solution().largestRectangleArea(data));
    }
}