package easy.green.binary_search;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    //    public int search(int[] nums, int target) {
//        return search(nums, 0, nums.length - 1, target);
//    }
//
//    public int search(int[] nums, int start, int end, int target) {
//        if (start > end) {
//            return -1;
//        }
//        int mid = (start + end) / 2;
//        if (nums[mid] > target) {
//            return search(nums, start, end - 1, target);
//        } else if (nums[mid] < target) {
//            return search(nums, start + 1, end, target);
//        } else {
//            return mid;
//        }
//    }
    public int search(int[] nums, int target) {
        int length = nums.length;
        int leftIndex = 0;
        int rightIndex = length - 1;
        while (leftIndex <= rightIndex) {
            int middle = (leftIndex + rightIndex) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (target < nums[middle]) {
                rightIndex = middle - 1;
            } else {
                leftIndex = middle + 1;
            }
        }
        return -1;
    }
}