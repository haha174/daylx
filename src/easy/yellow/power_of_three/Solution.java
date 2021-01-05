package easy.yellow.power_of_three;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：n = 45
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= n <= 231 - 1
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
     //   return Integer.toString(n, 3).matches("^10*$");
        return n > 0 && 1162261467 % n == 0;
/**
 * 一个重要的信息可以从函数名中推导出来。
 *
 * Java
 *
 * public boolean isPowerOfThree(int n)
 * 我们可以看出 n 的类型是 int。在 Java 中说明了该变量是四个字节，他的最大值为 2147483647。有三种方法可以计算出该最大值。
 *
 * Google
 * System.out.println(Integer.MAX_VALUE);
 * MaxInt = \frac{ 2^{32} }{2} - 1
 * 2
 * 2
 * 32
 *
 * ​
 *  −1 ,因为我们使用 32 位来表示数字，所以范围的一半用于负数，0 是正数的一部分。
 * 知道了 n 的限制，我们现在可以推断出 n 的最大值，也就是 3 的幂，是 1162261467。我们计算如下：
 *
 * 3^{\lfloor{}\log_3{MaxInt}\rfloor{}} = 3^{\lfloor{}19.56\rfloor{}} = 3^{19} = 1162261467
 * 3
 * ⌊log
 * 3
 * ​
 *  MaxInt⌋
 *  =3
 * ⌊19.56⌋
 *  =3
 * 19
 *  =1162261467
 *
 * 因此，我们应该返回 true 的 n 的可能值是 3^03
 * 0
 *  ，3^13
 * 1
 *  …3 ^ {19}3
 * 19
 *  。因为 3 是质数，所以 3^{19}3
 * 19
 *   的除数只有 3^03
 * 0
 *  ，3^13
 * 1
 *  …3 ^{19}3
 * 19
 *  ，因此我们只需要将 3^{19}3
 * 19
 *   除以 n。若余数为 0 意味着 n 是 3^{19}3
 * 19
 *   的除数，因此是 3 的幂。
 *
 * Java
 *
 * public class Solution {
 *     public boolean isPowerOfThree(int n) {
 *         return n > 0 && 1162261467 % n == 0;
 *     }
 * }
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/power-of-three/solution/3de-mi-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

    }
    /**
     * public class Solution {
     *     public boolean isPowerOfThree(int n) {
     *         return (Math.log10(n) / Math.log10(3)) % 1 == 0;
     *     }
     * }
     * 常见的陷阱 :
     * 这个解决方案是有问题的，因为我们开始使用 double s，这意味着我们会遇到精度错误。说明在比较双精度数时不应使用 ==。这是因为 Math.log10(n)/Math.log10(3) 的结果可能是 5.0000001 或 4.9999999。使用 Math.log() 函数而不是Math.log10() 可以观察到这种效果。
     *
     * 为了解决这个问题，我们需要将结果与 epsilon 进行比较。
     *
     * Java
     *
     * return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/power-of-three/solution/3de-mi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}

