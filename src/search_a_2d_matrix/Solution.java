package search_a_2d_matrix;

class Solution {
    // 二位数组中的二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowLength = matrix.length;
        int[] matrixL = new int[rowLength];
        for (int i = 0; i < rowLength; i++) {
            matrixL[i] = matrix[i][0];
        }
        int row = foundFlag(matrixL, 0, rowLength-1, target);
        System.out.println(row);
        if (matrix[row][0] == target) {
            return true;
        } else {
            int cow = foundFlag(matrix[row], 0, matrix[row].length-1, target);
            if (matrix[row][cow] == target) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int foundFlag(int[] data, int startIndex, int endIndex, int num) {
        if (startIndex == endIndex || endIndex-startIndex==1) {
            if (data[endIndex]<=num){
                return endIndex;
            }else {
                return startIndex;
            }
        }
        int mid = (startIndex + endIndex) / 2;
        if (data[mid] > num) {
            return foundFlag(data, startIndex, mid, num);
        } else if (data[mid] < num) {
            return foundFlag(data, mid, endIndex, num);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[][] data={
        {1,   3,  5,  7}
        ,{10, 11, 16, 20}
        ,{23, 30, 34, 50}
        // ,{70, 71, 72, 73}
    };
        System.out.println(new Solution().searchMatrix(data,30));
    }
}