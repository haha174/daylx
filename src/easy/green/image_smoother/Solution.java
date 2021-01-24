package easy.green.image_smoother;

/**
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * 输出:
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/image-smoother
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int count = 1;
                int n1, n2, n3, n4, n6, n7, n8, n9;

                if (i - 1 >= 0 && j - 1 >= 0) {
                    n1 = M[i - 1][j - 1];
                    count++;
                } else {
                    n1 = 0;
                }

                if (i - 1 >= 0) {
                    n2 = M[i - 1][j];
                    count++;
                } else {
                    n2 = 0;
                }

                if (i - 1 >= 0 && j + 1 < M[0].length) {
                    n3 = M[i - 1][j + 1];
                    count++;
                } else {
                    n3 = 0;
                }


                if (j - 1 >= 0) {
                    n4 = M[i][j - 1];
                    count++;
                } else {
                    n4 = 0;
                }

                if (j + 1 < M[0].length) {
                    n6 = M[i][j + 1];
                    count++;
                } else {
                    n6 = 0;
                }


                if (i + 1 < M.length && j - 1 >= 0) {
                    n7 = M[i + 1][j - 1];
                    count++;
                } else {
                    n7 = 0;
                }

                if (i + 1 < M.length) {
                    n8 = M[i + 1][j];
                    count++;
                } else {
                    n8 = 0;
                }

                if (i + 1 < M.length && j + 1 < M[0].length) {
                    n9 = M[i + 1][j + 1];
                    count++;
                } else {
                    n9 = 0;
                }
                result[i][j] = (int) ((M[i][j]+n1 + n2 + n3 + n4 + n6 + n7 + n8 + n9) / count);

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] data = {{2, 3, 4}
                      , {5, 6, 7}
                      , {8, 9, 10}
                      , {11, 12, 13}
                      , {14, 15, 16}};
        System.out.println(new Solution().imageSmoother(data));
    }
}