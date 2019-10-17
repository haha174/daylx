package spiral_matrix;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;

        }
        int steps=matrix.length*matrix[0].length;
        int step=0;
        int length = matrix.length;
        int width = matrix[0].length;
        int times = Math.min((length + 1) / 2, (width + 1) / 2);
        for (int k = 0; k < times; k++) {

            for (int j = k; j < width - 1 - k&&step<steps; j++) {
                result.add(matrix[k][j]);
                step++;
            }

            for (int j = k; j < length - 1 - k&&step<steps; j++) {
                result.add(matrix[j][width - 1 - k]);
                step++;
            }

            for (int j = width - 1 - k; j > k&&step<steps; j--) {
                result.add(matrix[length - 1 - k][j]);
                step++;
            }

            for (int j = length - 1 - k; j > k&&step<steps; j--) {
                result.add(matrix[j][k]);
                step++;
            }

        }
        if (length == width && length % 2 == 1) {
            result.add(matrix[length / 2][width / 2]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] data = {

                {6,9,7}};
        System.out.println(new Solution().spiralOrder(data));

    }
}
