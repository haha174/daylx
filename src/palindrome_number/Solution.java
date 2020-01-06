package palindrome_number;

/**
 * https://leetcode.com/problems/palindrome-number/
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x <0){
            return false;
        }

        int result = 0;
        int original=x;
        while (x > 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
         if (original== result){
            return true;
        } else{
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(0));
    }
}