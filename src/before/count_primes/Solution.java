package before.count_primes;

/**
 *https://leetcode.com/problems/count-primes/
 *
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
class Solution {
    public int countPrimes(int n) {
        if (n <= 2){
            return 0;
        }
        boolean [] a = new boolean[n];
        int count = n/2;
        for(int i = 3; i*i <= n; i+=2){
            if(a[i]) continue;
            for(int j = i*i; j < n; j += 2*i){
                if(a[j])
                    continue;
                count--;
                a[j] = true;
            }
        }
        return count;
    }
}