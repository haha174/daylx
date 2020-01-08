package pascals_triangle_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * pascals-triangle-ii
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] dp = new int[rowIndex + 1];
        List<Integer> res = new ArrayList<>();
        int i, j;
        dp[0] = 1;
        for (i = 0; i <= rowIndex; i++) {
            for (j = i; j >= 1; j--) {
                dp[j] += dp[j - 1];
            }
        }
        for (j = 0; j <= rowIndex; j++) {
            res.add(dp[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(5));
    }
}