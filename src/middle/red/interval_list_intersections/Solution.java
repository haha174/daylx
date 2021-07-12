package middle.red.interval_list_intersections;

/**
 *
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 *
 * 返回这 两个区间列表的交集 。
 *
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 *
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 示例 2：
 *
 * 输入：firstList = [[1,3],[5,9]], secondList = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：firstList = [], secondList = [[4,8],[10,12]]
 * 输出：[]
 * 示例 4：
 *
 * 输入：firstList = [[1,7]], secondList = [[3,10]]
 * 输出：[[3,7]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.*;
class Solution {
//    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
//        List<int[]> result=new ArrayList<>();
//        for (int i=0;i<firstList.length;i++){
//            int[] first=firstList[i];
//            for (int j=0;j<secondList.length;j++){
//                int[] second=secondList[j];
//                if (first[0]>second[1] || first[1]<second[0]){
//                    continue;
//                }
//                int[] tempResult=new int[2];
//                tempResult[0]=Math.max(first[0],second[0]);
//                tempResult[1]=Math.min(first[1],second[1]);
//                result.add(tempResult);
//            }
//        }
//        return result.toArray(new int[result.size()][]);
//    }
public int[][] intervalIntersection(int[][] A, int[][] B) {
    List<int[]> ans = new ArrayList();
    int i = 0, j = 0;

    while (i < A.length && j < B.length) {
        // Let's check if A[i] intersects B[j].
        // lo - the startpoint of the intersection
        // hi - the endpoint of the intersection
        int lo = Math.max(A[i][0], B[j][0]);
        int hi = Math.min(A[i][1], B[j][1]);
        if (lo <= hi)
            ans.add(new int[]{lo, hi});

        // Remove the interval with the smallest endpoint
        if (A[i][1] < B[j][1])
            i++;
        else
            j++;
    }

    return ans.toArray(new int[ans.size()][]);
}

    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}}, secondList = {{1,5},{8,12},{15,24},{25,26}};
        System.out.println(new Solution().intervalIntersection(firstList,secondList));
    }
}