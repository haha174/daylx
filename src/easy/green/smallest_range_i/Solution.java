package easy.green.smallest_range_i;

/**
 * 给你一个整数数组 A，请你给数组中的每个元素 A[i] 都加上一个任意数字 x （-K <= x <= K），从而得到一个新数组 B 。
 *
 * 返回数组 B 的最大值和最小值之间可能存在的最小差值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * 示例 2：
 *
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * 示例 3：
 *
 * 输入：A = [1,3,6], K = 3
 * 输出：0
 * 解释：B = [3,3,3] 或 B = [4,4,4]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int smallestRangeI(int[] A, int K) {
        if(A.length==1)return 0;
        int sum=0;
        int max=0;
        int min=Integer.MAX_VALUE;
        for (int i=0;i<A.length;i++){
            sum+=A[i];
            if (A[i]>max){
                max=A[i];
            }
            if (A[i]<min){
                min=A[i];
            }
        }
       int ave=sum/A.length;
        if (ave<K){
            return 0;
        }
        return (max-min-K*2)<0?0:(max-min-K*2);
    }

    public static void main(String[] args) {
        int[] data={3,1,10};
        System.out.println(new Solution().smallestRangeI(data,4));
    }
}