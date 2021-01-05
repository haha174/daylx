package before.sqrtx;

/**
 * https://leetcode.com/problems/sqrtx/
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * Example 1:
 * Input: 4
 * Output: 2
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
class Solution {
    public int mySqrt(int x) {
        if (x==1) return 1;
        long  begin=0;
        long  end=x;

        while (true){
            long  mid=(begin+end)/2;
            if (mid==begin){
                break;
            }
            if (mid*mid==x){
             return (int)mid;
            }if (mid*mid>x){
                end=mid;
            }else {
                begin=mid;
            }
        }
        return (int)begin;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2147395599));
    }
}