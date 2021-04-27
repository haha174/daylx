package easy.green.number_of_rectangles_that_can_form_the_largest_square;

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0, ans = 0;
        for (int[] rect : rectangles) {
            int len = Math.min(rect[0], rect[1]);
            if (len > maxLen) {
                maxLen = len;
                ans = 1;
            } else if (len == maxLen) {
                ans++;
            }
        }
        return ans;
    }
}
