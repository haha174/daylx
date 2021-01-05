package before.number_complement;

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */
class Solution {
    public int findComplement(int num) {
        if(num == 1){
            return 0;
        }
        int mask = (1 << getSignificantBit(num)) - 1; // Make all bits 0 before the significant(inclusive) bit and 1 after the significant bit
        return num ^ mask;
    }
    // Get the significant bit that has a 1 in a given number
    public int getSignificantBit(int num){
        int significantBit = 0;
        while (num != 1) {
            num = num/2;
            ++significantBit;
            if(num==1) {
                ++significantBit;
            }
        }
        return significantBit;
    }
}