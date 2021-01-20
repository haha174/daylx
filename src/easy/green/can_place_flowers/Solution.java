package easy.green.can_place_flowers;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int oneCount = 0;
        boolean canReplace = true;
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 1) {
                canReplace = false;
            } else if (flowerbed[i] == 0 && canReplace && flowerbed[i+1]==0) {
                canReplace = false;
                oneCount++;
            } else {
                canReplace = true;
            }
        }
        if (flowerbed[flowerbed.length-1] == 0 && canReplace ){
            oneCount++;
        }

        if (n > oneCount) return false;
        return true;
    }

    public static void main(String[] args) {
        int nums[] = {0, 0, 1, 0, 0};
        System.out.println(new Solution().canPlaceFlowers(nums, 2));
        ;
    }
}