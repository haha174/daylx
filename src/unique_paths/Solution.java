package unique_paths;

class Solution {
    public int uniquePaths(int m, int n) {
        m = m - 1;
        n = n - 1;
        if (n > m) {
            int temp = m;
            m = n;
            n = temp;
        }
        if (m <= 0 || n <= 0) {
            return 1;
        }
        int temp1 = 1;
        long temp2 = 1;
        for (int i = 1; i <= n; i++) {
            temp1 = temp1 * (m + i);
            temp2 = temp2 * (i);
        }
        return new Long(temp1 / temp2).intValue();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(13, 23));
        ;
    }
}