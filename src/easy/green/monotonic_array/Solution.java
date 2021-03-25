package easy.green.monotonic_array;

/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * <p>
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * <p>
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,2,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：[6,5,4,4]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：[1,3,2]
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：[1,2,4,5]
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：[1,1,1]
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotonic-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean isMonotonic(int[] A) {
        int flag = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                continue;
            } else if (A[i] - A[i - 1] > 0 && flag <0 ) {
                return false;
            } else if (A[i] - A[i - 1] < 0 && flag >0) {
                return false;
            } else {
                flag = A[i] - A[i - 1];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] data={1,3,2};
        System.out.println(new Solution().isMonotonic(data) );
    }
}