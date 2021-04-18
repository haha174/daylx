package easy.green.shift_2d_grid;

import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List res = new ArrayList<>();
        int m = grid.length;
        if (m == 0) return res;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[(i + (j + k) / n) % m][(j + k) % n] = grid[i][j];
            }
        }
        res = Arrays.asList(ans);
        return res;
    }


    public static void main(String[] args) {
        int[][] data = {{1}, {2}, {3}, {4}, {7}, {6}, {5}};
        System.out.println(new Solution().shiftGrid(data, 23));
    }
}