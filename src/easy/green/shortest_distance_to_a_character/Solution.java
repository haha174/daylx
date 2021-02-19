package easy.green.shortest_distance_to_a_character;

/**
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：S = "loveleetcode", C = 'e'
 * 输出：[3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *  
 * <p>
 * 提示：
 * <p>
 * 字符串 S 的长度范围为 [1, 10000]。
 * C 是一个单字符，且保证是字符串 S 里的字符。
 * S 和 C 中的所有字母均为小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        int one = -1;
        int two = -1;
        for (int i = 0; i < result.length; i++) {
            if (s.charAt(i) == c) {
                result[i] = 0;
                if (one == -1) {
                    one = i;
                }
                two = i;
            } else {
                result[i] = -1;
            }
        }

        for (int i = one; i > 0; i--) {
            result[one - i] = i;
        }

        while (one < two) {
            int nextOne = -1;
            for (int i = one+1; i <= two; i++) {
                if (result[i] == 0) {
                    nextOne = i;
                    break;
                }
            }
            int mid = (nextOne - one) / 2;
            while (mid > 0) {
                result[one + mid] = mid;
                result[nextOne - mid] = mid;
                mid--;
            }
            one = nextOne;
        }
        for (int i = two+1; i < result.length; i++) {
            result[i] =  i-two;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestToChar("loveleetcode", 'e'));
    }
}