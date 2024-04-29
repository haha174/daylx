package before.search_a_2d_matrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 3, 4, 5}
                , {6, 7, 8, 9, 10}
                , {11, 12, 13, 14, 15}
                , {16, 17, 18, 19, 20}
                , {21, 22, 23, 24, 25}
        };

        int[][] data1 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 100, 200}
        };


        System.out.println(new Solution().searchMatrix(data1, 100));
    }
}