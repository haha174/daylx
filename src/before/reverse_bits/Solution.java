package before.reverse_bits;

/**
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *https://leetcode.com/problems/reverse-bits/submissions/
 *
 *zl
 * Example 1:
 *
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * Example 2:
 *
 * Input: 11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 *
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for(int i=0; i < 31; i++) {
            ans += (n & 1);    // add the new bit
            ans = ans << 1;   // left shift ans to mantain previous bits
            n = n >> 1;         // get the right most bit
        }
        ans += (n & 1);

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(1011111));
    }
}