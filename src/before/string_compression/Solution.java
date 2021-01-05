package before.string_compression;

/**
 *
 * Given an array of characters, compress it in-place.
 *
 * The length after compression must always be smaller than or equal to the original array.
 *
 * Every element of the array should be a character (not int) of length 1.
 *
 * After you are done modifying the input array in-place, return the new length of the array.
 *
 *
 * Follow up:
 * Could you solve it using only O(1) extra space?
 *
 *
 * Example 1:
 *
 * Input:
 * ['a','a','b','b','c','c','c']
 *
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ['a','2','b','2','c','3']
 *
 * Explanation:
 * 'aa' is replaced by 'a2'. 'bb' is replaced by 'b2'. 'ccc' is replaced by 'c3'.
 *
 *
 * Example 2:
 *
 * Input:
 * ['a']
 *
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ['a']
 *
 * Explanation:
 * Nothing is replaced.
 *
 *
 * Example 3:
 *
 * Input:
 * ['a','b','b','b','b','b','b','b','b','b','b','b','b']
 *
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ['a','b','1','2'].
 *
 * Explanation:
 * Since the character 'a' does not repeat, it is not compressed. 'bbbbbbbbbbbb' is replaced by 'b12'.
 * Notice each digit has it's own entry in the array.
 *
 *
 * Note:
 *
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 *
 */
class Solution {
    public int compress(char[] chars) {
        int count = 1, position = 0, length = chars.length - 1, i = 0;

		while (i < length) {
			while (chars[i] == chars[i + 1]) {
				count++;
				i++;

				if (i == length) {
					if (count / 10 > 0) {
						chars[++position] = Character.forDigit(count / 10, 10);
						chars[++position] = Character.forDigit(count % 10, 10);
					} else {
						chars[++position] = Character.forDigit(count, 10);
					}
					return position + 1;
				}
			}

			if (count >= 10) {
				chars[++position] = Character.forDigit(count / 10, 10);
				chars[++position] = Character.forDigit(count % 10, 10);
				chars[++position] = chars[i + 1];
				count = 1;
			} else if (count == 1) {
				chars[++position] = chars[i + 1];
				count = 1;
			} else {
				chars[++position] = Character.forDigit(count, 10);
				chars[++position] = chars[i + 1];
				count = 1;
			}
			i++;
		}
		return position + 1;
    }

	public static void main(String[] args) {
		char[] data={'a','b','b','b','b','b','b','b','b','b','b','b','b','c'};
		System.out.println(new Solution().compress(data));
	}
}