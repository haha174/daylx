package easy.green.toeplitz_matrix;

/**
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * <p>
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * 输出: True
 * 解释:
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是True。
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * 输出: False
 * 解释:
 * 对角线"[1, 2]"上的元素不同。
 * 说明:
 * <p>
 *  matrix 是一个包含整数的二维数组。
 * matrix 的行数和列数均在 [1, 20]范围内。
 * matrix[i][j] 包含的整数在 [0, 99]范围内。
 * 进阶:
 * <p>
 * 如果矩阵存储在磁盘上，并且磁盘内存是有限的，因此一次最多只能将一行矩阵加载到内存中，该怎么办？
 * 如果矩阵太大以至于只能一次将部分行加载到内存中，该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        for (int i = 0; i < y; i++) {
            int h = x - 1;
            int s = i;
            int pre = matrix[h][s];
            while (h >= 0 && s >= 0) {
                if (matrix[h][s] != pre) {
                    return false;
                }
                h--;
                s--;
            }
        }


        for (int i  = x-2; i>=0; i--) {
            int h = i;
            int s = y -1;
            int pre = matrix[h][s];
            while (h >= 0 && s >= 0) {
                if (matrix[h][s] != pre) {
                    return false;
                }
                h--;
                s--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}};
        int [][] matrix = {{1,2},{2,2}};
        System.out.println(new Solution().isToeplitzMatrix(matrix));
    }
}