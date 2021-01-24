package easy.green.degree_of_an_array;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 * <p>
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] start = new int[50000];
        int[] count = new int[50000];
        int end=0;
        int maxCount = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int in = nums[i];
            count[in] =++ count[in];
            if (count[in] > maxCount||(count[in] == maxCount && end-start[max]>i- start[in])) {
                max = in;
                maxCount = count[in];
                end= i;
            }
            if (start[in] == 0) {
                start[in] = i+1;
            }

        }
        return end-start[max]+2;
    }

    public static void main(String[] args) {
        int[] data={2,1,1,2,1,3,3,3,1,3,1,3,2};
        System.out.println(new Solution().findShortestSubArray(data));
    }
}