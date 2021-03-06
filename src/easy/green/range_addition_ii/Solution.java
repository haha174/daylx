package easy.green.range_addition_ii;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
 * <p>
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
 * <p>
 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * m = 3, n = 3
 * operations = [[2,2],[3,3]]
 * 输出: 4
 * 解释:
 * 初始状态, M =
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * <p>
 * 执行完操作 [2,2] 后, M =
 * [[1, 1, 0],
 * [1, 1, 0],
 * [0, 0, 0]]
 * <p>
 * 执行完操作 [3,3] 后, M =
 * [[2, 2, 1],
 * [2, 2, 1],
 * [1, 1, 1]]
 * <p>
 * M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
 * 注意:
 * <p>
 * m 和 n 的范围是 [1,40000]。
 * a 的范围是 [1,m]，b 的范围是 [1,n]。
 * 操作数目不超过 10000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-addition-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    //    public int maxCount(int m, int n, int[][] ops) {
//        int[][] result = new int[m][n];
//        for (int i = 0; i < ops.length; i++) {
//            int c1 = ops[i][0];
//            int c2 = ops[i][1];
//            for (int j = 0; j < c1; j++) {
//                for (int k = 0; k < c2; k++) {
//                    result[j][k]=++result[j][k];
//                }
//            }
//        }
//        int count=0;
//        int maxCount=result[0][0];
//        for (int j = 0; j < m; j++) {
//            for (int k = 0; k < n; k++) {
//               if (maxCount==result[j][k]){
//                   count++;
//               }
//            }
//        }
//        return count;
//    }
    public int maxCount(int m, int n, int[][] ops) {
        int minL=m;
        int minR=n;
        for (int i = 0; i < ops.length; i++) {
            int c1 = ops[i][0];
            int c2 = ops[i][1];
           if (c1<minL){
               minL=c1;
           }
            if (c2<minR){
                minR=c2;
            }
        }
        return minL*minR;
    }
}