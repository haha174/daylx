package before.set_matrix_zeroes;

class Solution {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0)
            return;

        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    col[j] = true;
                    for (int k = 0; k < matrix[0].length; k++) {
                        if (matrix[i][k] == 0){
                            col[k] = true;
                        }
                        matrix[i][k] = 0;
                    }
                    break;
                }
            }
        }

        for (int i = 0; i < col.length; i++) {
            if (col[i] == true) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

    }

//    public void setZeroes(int[][] matrix) {
//        int tempIndex=13145200;
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return;
//        }
//        int length = matrix.length;
//        int height = matrix[0].length;
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < height; j++) {
//                if (matrix[i][j] == 0) {
//                    for (int tmpI = 0; tmpI < height; tmpI++) {
//                        if (matrix[i][tmpI] != 0) {
//                            matrix[i][tmpI] = tempIndex;
//                        }
//                    }
//                    for (int tmpI = 0; tmpI < length; tmpI++) {
//                        if (matrix[tmpI][j] != 0) {
//                            matrix[tmpI][j] = tempIndex;
//                        }
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < height; j++) {
//                if (matrix[i][j] == tempIndex) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        int[][] data = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new Solution().setZeroes(data);
        System.out.println();
    }
}