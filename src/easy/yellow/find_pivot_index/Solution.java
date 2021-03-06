package easy.yellow.find_pivot_index;

/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * <p>
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2：
 * <p>
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    //    public int pivotIndex(int[] nums) {
//        for (int i = 0; i < nums.length ; i++) {
//            int left = 0;
//            int right = 0;
//            for (int j = 0; j < i; j++) {
//                left = left + nums[j];
//            }
//            for (int j = i + 1; j < nums.length; j++) {
//                right = right + nums[j];
//            }
//            if (left == right) return i;
//        }
//        return -1;
//    }
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int leftSum = 0, rightSum = 0;

        for (int i = 1; i < nums.length; i++)
            rightSum += nums[i];


        if (leftSum == rightSum)
            return 0;

        for (int i = 1; i < nums.length; i++) {
            rightSum -= nums[i];
            leftSum += nums[i - 1];
            if (rightSum == leftSum)
                return i;
        }

        return -1;
    }
}