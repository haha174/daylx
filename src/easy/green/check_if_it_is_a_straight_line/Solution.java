package easy.green.check_if_it_is_a_straight_line;

/**
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * <p>
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    public boolean checkStraightLine(int[][] coordinates) {
        /*
         *   一般式：Ax+By+C=0（AB≠0）
         *   两点式：(y-y1)/(x-x1)=(y-y2)/(x-x2) 　（直线过定点(x1,y1),(x2,y2)）
         */

        // 这里取定点为coordinates[0],和coordinates[n-1]
        // 为避免除法运算，这里用“两内项的积等于两外项的积”计算
        int n = coordinates.length;
        for (int i = 1; i < n - 1; ++i) {
            if (
                    (coordinates[i][0] - coordinates[0][0]) *    /* (x-x1)*(y-y2) */
                            (coordinates[i][1] - coordinates[n - 1][1])
                            !=
                            (coordinates[i][1] - coordinates[0][1]) *    /* (y-y1)*(x-x2) */
                                    (coordinates[i][0] - coordinates[n - 1][0])

            ) return false;
        }
        return true;
    }
}