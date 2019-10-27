package permutation_sequence;

import java.util.ArrayList;

/**
 * 这边取了一个factorial 数据 保存每取没位数字需要交换的次数， 通过k/factorial [n-1]  依次取得每位数
 * 因为除了 k/factorial [n-1] 所以下载迭代的时候需要对其求余
 */
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k--;
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        while (n > 0) {
            int p = k / factorial[n - 1];
            res.append(nums.remove(p));
            k = k % factorial[n - 1];
            n = n - 1;
        }
        return res.toString();
}


    public static void main(String[] args) {
        System.out.println( new Solution().getPermutation(5,31));
    }
}