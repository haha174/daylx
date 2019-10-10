package rotate_image;

/**
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 *
 *Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 */

public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = i; j < matrix[0].length - 1 - i; j++) {
                /**
                 * 本题实际上就是4个点的循环替换的一个过程
                 * 取 portTwo= matrix.length-1-i;
                 * 取 portThree=matrix[0].length-1-j;
                 * 4个点是有规律的他们分别是 (i,j)(j,portTwo)(portTwo,portThree)(portThree,i)
                 *portTwo portThree 都可以通过ij 得到实际上只需要怎么确定 i,j 就可以了
                 * 可以发现   i  在  0到matrix.length/2  之间   并且 i=<j < matrix[0].length - 1 - i
                 * 这样就将整体的取值范围缩小到了很小了    4✖4的数组的话   ij  可以取值的有4个点 (0,0) (0,1) (0,2)(1,1)
                 * 然后   将这4个点相互交换数据即可  (i,j)(j,portTwo)(portTwo,portThree)(portThree,i)
                 *
                 */
                int portTwo= matrix.length-1-i;
                int portThree= matrix[0].length-1-j;
                int temp = matrix[j][portTwo];
                matrix[j][portTwo] = matrix[i][j];
                matrix[i][j] = matrix[portThree][i];
                matrix[portThree][i]= matrix[portTwo][portThree];
                matrix[portTwo][portThree] = temp;
            }
        }
        printMatrix(matrix);

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new Solution().rotate(matrix);
    }
}
