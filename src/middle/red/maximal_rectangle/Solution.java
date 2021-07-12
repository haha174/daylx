package middle.red.maximal_rectangle;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) return 0;
        int m = matrix[0].length;
        int[][] matrix1 = new int[n][m];
        for(int i = 0;i < m;i++){
            if(matrix[0][i] == '1') matrix1[0][i] = 1;
        }
        for(int i = 1;i < n;i++){
            for(int j = 0;j < m;j++){
                if(matrix[i][j] == '1') 
                    matrix1[i][j] = matrix1[i - 1][j] + 1;
            }
        }
        int ans = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(matrix1[i][j] * m <= ans) continue;
                if(matrix1[i][j] != 0){
                    int cnt = 1;
                    for(int k = j + 1;k < m;k++){
                        if(matrix1[i][k] < matrix1[i][j]) break;
                        cnt++;
                    }
                    for(int k = j - 1;k >= 0;k--){
                        if(matrix1[i][k] < matrix1[i][j]) break;
                        cnt++;
                    }
                    ans = Math.max(ans, cnt * matrix1[i][j]);
                }
            }
        }
        return ans;
    }
}
