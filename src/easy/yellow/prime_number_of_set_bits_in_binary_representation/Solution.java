package easy.yellow.prime_number_of_set_bits_in_binary_representation;

/**
 * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 * <p>
 * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 * <p>
 * 示例 1:
 * <p>
 * 输入: L = 6, R = 10
 * 输出: 4
 * 解释:
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * 示例 2:
 * <p>
 * 输入: L = 10, R = 15
 * 输出: 5
 * 解释:
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 注意:
 * <p>
 * L, R 是 L <= R 且在 [1, 10^6] 中的整数。
 * R - L 的最大值为 10000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    //    public int countPrimeSetBits(int L, int R) {
//        int count = 0;
//        for (int i = L; i <= R; i++) {
//            if (isZ(getOneCount(i))) {
//                System.out.println(i);
//                count++;
//            }
//        }
//        return count;
//    }
//
//    public boolean isZ(int count) {
//        if (count < 2) return false;
//        for (int i = 2; i <= Math.sqrt(count); i++) {
//            if (count % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public int getOneCount(int num) {
//        int count = 0;
//        while (num > 0) {
//            if (num % 2 == 1) {
//                count++;
//            }
//            num = num / 2;
//        }
//        return count;
//    }
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
            res += 665772 >> Integer.bitCount(i) & 1;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().countPrimeSetBits(256, 256);
    }
}