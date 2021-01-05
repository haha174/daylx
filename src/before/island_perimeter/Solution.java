package before.island_perimeter;

/**
 * Share
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * Output: 16
 * <p>
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
class Solution {
    public int islandPerimeter(int[][] grid) {
//        if (grid== null || grid.length==0|| grid[0].length==0){
//            return 0;
//        }
//        int count=0;
//        int row=grid.length;
//        int cow=grid[0].length;
//        for (int i=0;i<row;i++){
//            for (int j=0;j<cow;j++){
//                // i,j compare i,j-1  i-1,j   i,j+1 i+1 j
//                if(grid[i][j]!=1){
//                    continue;
//                }
//                if (j-1<0|| grid[i][j]-grid[i][j-1]==1){
//                    count++;
//                }
//                if (i-1<0|| grid[i][j]-grid[i-1][j]==1){
//                    count++;
//                }
//                if (j+1==cow||grid[i][j]- grid[i][j+1]==1){
//                    count++;
//                }
//                if (i+1==row||grid[i][j]- grid[i+1][j]==1){
//                    count++;
//                }
//            }
//        }
//        return count;
        int result = 0;
        for (
                int i = 0;
                i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;

                    if (i > 0 && grid[i - 1][j] == 1) {
                        result -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }
}