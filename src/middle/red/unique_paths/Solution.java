package middle.red.unique_paths;

import java.util.Arrays;

class Solution {
//    public int uniquePaths(int m, int n) {
//        int[] cur = new int[n];
//        Arrays.fill(cur,1);
//        for (int i = 1; i < m;i++){
//            for (int j = 1; j < n; j++){
//                cur[j] += cur[j-1] ;
//            }
//        }
//        return cur[n-1];
//    }

    public int uniquePaths(int m, int n) {
        int[][] cur = new int[m][n];
        for (int i = 0; i < m;i++){
            for (int j = 0; j < n; j++){
               if (i==0|| j==0){
                   cur[i][j]=1;
               }else {
                   cur[i][j]=cur[i-1][j]+cur[i][j-1];
               }

            }
        }
        return cur[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3,7));
    }
}


