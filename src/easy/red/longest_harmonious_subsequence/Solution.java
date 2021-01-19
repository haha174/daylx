package easy.red.longest_harmonious_subsequence;

import java.util.HashMap;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * <p>
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    //    int maxCount = 0;
//
//    public int findLHS(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int temp = nums[i];
//            int tempCount = 0;
//            int tempCount1 = 0;
//            int tempCount2 = 0;
//            int tempCount3 = 0;
//
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[j] == temp) {
//                    tempCount1++;
//                }
//                if (nums[j] == temp + 1) {
//                    tempCount2++;
//                }
//                if (nums[j] == temp - 1) {
//                    tempCount3++;
//                }
//            }
//            tempCount = Math.max(tempCount1 + tempCount2, tempCount1 + tempCount3);
//            if (tempCount > maxCount) {
//                maxCount = tempCount;
//                if (tempCount2 == 0 && tempCount3 == 0) maxCount=0;
//            }
//        }
//        return maxCount;
//    }
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;
    }

//    public int findLHS(int[] nums) {
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int count = 0;
//            boolean flag = false;
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[j] == nums[i])
//                    count++;
//                else if (nums[j] + 1 == nums[i]) {
//                    count++;
//                    flag = true;
//                }
//            }
//            if (flag)
//                res = Math.max(count, res);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(new Solution().findLHS(nums));
    }
}