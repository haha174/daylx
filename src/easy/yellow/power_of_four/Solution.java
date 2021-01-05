package easy.yellow.power_of_four;

/**
 * 方法四：位运算 + 数学运算
 * 算法：
 *
 * 我们首先检车 xx 是否为 2 的幂：x > 0 and x & (x - 1) == 0。然后可以确定 x = 2^ax=2
 * a
 *  ，若 xx 为 4 的幂则 aa 为偶数。
 * 下一步是考虑 a=2ka=2k 和 a=2k+1a=2k+1 两种情况，对 xx 对 3 进行取模：
 * (2^{2k} \mod 3) = (4^k \mod 3) = ((3 + 1)^k \mod 3) = 1(2
 * 2k
 *  mod3)=(4
 * k
 *  mod3)=((3+1)
 * k
 *  mod3)=1
 *
 * ((2^{2k + 1}) \mod 3) = ((2 \times 4^k) \mod 3) = ((2 \times(3 + 1)^k) \mod 3) = 2((2
 * 2k+1
 *  )mod3)=((2×4
 * k
 *  )mod3)=((2×(3+1)
 * k
 *  )mod3)=2
 *
 * 若 xx 为 2 的幂且 x%3 == 1，则 xx 为 4 的幂。
 * PythonJava
 *
 * class Solution {
 * class Solution:
 *     def isPowerOfFour(self, num: int) -> bool:
 *         return num > 0 and num & (num - 1) == 0 and num % 3 == 1
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/power-of-four/solution/4de-mi-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/**
 * (2
 * 2k
 *  mod3)=(4
 * k
 *  mod3)=((3+1)
 * k
 *  mod3)=1
 *
 * ((2^{2k + 1}) \mod 3) = ((2 \times 4^k) \mod 3) = ((2 \times(3 + 1)^k) \mod 3) = 2((2
 * 2k+1
 *  )mod3)=((2×4
 * k
 *  )mod3)=((2×(3+1)
 * k
 *  )mod3)=2
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/power-of-four/solution/4de-mi-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
    }
}