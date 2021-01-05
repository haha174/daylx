package before.spiral_matrix_ii;

/**
 * url :https://leetcode.com/problems/spiral-matrix-ii/
 */
class Solution {
    public int[][] generateMatrix(int n) {

        int[][] result=new int[n][n];
        if(n<=0){
            return result;
        }
        int times=(n+1)/2;
        int addCount=1;
        for (int k=0;k<times;k++){
            for (int i=k;i<n-k-1&&addCount<=n*n;i++){
                result[k][i]=addCount++;
            }
            for (int i=k;i<n-k-1&&addCount<=n*n;i++){
                result[i][n-k-1]=addCount++;
            }

            for (int i=k;i<n-k-1&&addCount<=n*n;i++){
                result[n-k-1][n-1-i]=addCount++;
            }

            for (int i=k;i<n-k-1&&addCount<=n*n;i++){
                result[n-1-i][k]=addCount++;
            }
        }
        if ( n % 2 == 1) {
            result[times-1][times-1]=addCount;
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().generateMatrix(4);
    }
}