package before.license_key_formatting;

/**
 * https://leetcode.com/problems/license-key-formatting/
 * <p>
 * You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.
 * <p>
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
 * <p>
 * Given a non-empty string S and a number K, format the string according to the rules described above.
 * <p>
 * Example 1:
 * Input: S = "5F3Z-2e-9-w", K = 4
 * <p>
 * Output: "5F3Z-2E9W"
 * <p>
 * Explanation: The string S has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 * Example 2:
 * Input: S = "2-5g-3-J", K = 2
 * <p>
 * Output: "2-5G-3J"
 * <p>
 * "--a-a-a-a--"
 * 2
 * <p>
 * Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 */
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        char[] data = S.toCharArray();
        int count = 0;
        for (char l : data)
            if (l != '-')
                count++;

        int l = data.length - 1;
        int newLength = count + ((count - 1) / K);
        char[] newLetters = new char[newLength];
        int current = 0;
        while (l >= 0 && newLength>0) {
            if (data[l] != '-') {
                newLetters[--newLength]=Character.toUpperCase(data[l]);
                current++;
                count--;
            }
            if (count>0 && current == K) {
                newLetters[--newLength]='-';
                current = 0;
            }
            l--;
        }
        return new String(newLetters);
    }
//    public String licenseKeyFormatting(String S, int K) {
//        char[] letters = S.toCharArray();
//        int count = 0;
//        for (char l : letters)
//            if (l != '-')
//                count++;
//        int newLength = count + ((count - 1) / K);
//        char[] newLetters = new char[newLength];
//        int len = 0;
//        for (int i = letters.length - 1, j = newLetters.length - 1; i >= 0; i--) {
//            if (letters[i] != '-') {
//                newLetters[j--] = Character.toUpperCase(letters[i]);
//                len++;
//                if (j > 0 && len % K == 0) {
//                    newLetters[j--] = '-';
//                    len = 0;
//                }
//            }
//        }
//        return new String(newLetters);
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().licenseKeyFormatting("--a-a-a-a--", 2));
    }
}