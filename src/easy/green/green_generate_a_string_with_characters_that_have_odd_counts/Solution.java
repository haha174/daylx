package easy.green.green_generate_a_string_with_characters_that_have_odd_counts;

import java.util.Arrays;

class Solution {
    public String generateTheString(int n) {
        char[] cs = new char[n];
        Arrays.fill(cs, 'a');
        if ((n & 1) == 0) {
            cs[0] = 'b';
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        new Solution().generateTheString(3);
    }
}

