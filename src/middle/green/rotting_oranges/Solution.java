package middle.green.rotting_oranges;

class Solution {
    public int orangesRotting(int[][] grid) {
        int result = 0;
        while (!done(grid)) {
            result++;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        if (i > 0 && grid[i - 1][j] == 1) {
                            grid[i - 1][j] = -1;
                        }
                        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                            grid[i + 1][j] = -1;
                        }
                        if (j > 0 && grid[i][j - 1] == 1) {
                            grid[i][j - 1] = -1;
                        }
                        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                            grid[i][j + 1] = -1;
                        }
                    }
                }
            }
           int repairCount=  repair(grid);
            if (repairCount==0){
                return -1;
            }
        }
        return result;
    }

    public boolean done(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int repair(int[][] grid) {
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    grid[i][j] = 2;
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
      //  int[][] data = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] data = {{2, 1, 1}, {0,1,1}, {1,0,1}};
        System.out.println(new Solution().orangesRotting(data));
    }
}