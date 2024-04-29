package before.spiral_matrix;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        int steps=matrix.length*matrix[0].length;
        int step=0;
        int flag=0; // 0 1 2 3
        int i=0,j=0;
        if (matrix[0].length==1){
            flag=1;
        }
        while (step<steps){
            result.add(matrix[i][j]);
            switch (flag%4){
                case 0: j++; if (j>=matrix[0].length-1-flag/4){flag++;} break;
                case 1: i++; if (i>=matrix.length-1-flag/4){flag++;} break;
                case 2: j--; if (j<=flag/4){flag++;} break;
                case 3: i--; if (i<=flag/4+1){flag++;} break;
            }
            step++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] data = {{3},{2}};
        System.out.println(new Solution().spiralOrder(data));
    }
}
