package easy.green.largest_number_at_least_twice_of_others;

/**
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * <p>
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * <p>
 * 如果是，则返回最大元素的索引，否则返回-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) return 0;
        int max = nums[0];
        int index = 0;
        if (nums[1] > nums[0]) {
            max = nums[1];
            index = 1;
        }
        int secondMax = nums[1] + nums[0] - max;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        if (secondMax*2>max){
            return -1;
        }
        return index;
    }

    public static void main(String[] args) {
        int data[]={1,0,0,0};
        System.out.println(new Solution().dominantIndex(data));
    }
}