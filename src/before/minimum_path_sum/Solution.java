package before.minimum_path_sum;

class Solution {
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        if (m == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int n = grid[0].length;
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 && j == 0) {
//                    continue;
//                } else if (i == 0) {
//                    grid[i][j] = grid[i][j] + grid[i][j - 1];
//                } else if (j == 0) {
//                    grid[i][j] = grid[i][j] + grid[i - 1][j];
//                } else {
//                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
//                }
//            }
//        }
//        return grid[m - 1][n - 1];
//    }

        public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        return dfs(grid, dp, m - 1, n - 1);
    }

    private int dfs(int[][] grid, int[][] dp, int m, int n) {
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;
        if (m == 0 && n == 0)
            return grid[0][0];

        if (dp[m][n] == 0)
            dp[m][n] = grid[m][n] + Math.min(dfs(grid, dp, m - 1, n), dfs(grid, dp, m, n - 1));
        return dp[m][n];
    }
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        if (m == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int n = grid[0].length;
//        int[][] data = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 && j == 0) {
//                    data[0][0] = grid[0][0];
//                } else if (data[i][j] == 0) {
//                    if (i == 0) {
//                        data[i][j] = grid[i][j] + data[i][j - 1];
//                    } else if (j == 0) {
//                        data[i][j] = grid[i][j] + data[i - 1][j];
//                    } else {
//                        data[i][j] = grid[i][j] + Math.min(data[i - 1][j], data[i][j - 1]);
//                    }
//                }
//            }
//        }
//        return data[m - 1][n - 1];
//    }

    public static void main(String[] args) {
        int[][] grid = {{0}};
        System.out.println(new Solution().minPathSum(grid));
    }
}