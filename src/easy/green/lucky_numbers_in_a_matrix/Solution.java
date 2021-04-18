package easy.green.lucky_numbers_in_a_matrix;
import java.util.*;
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            int temp=matrix[i][0];
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] < temp){
                    temp=matrix[i][j];
                }
            }
            list.add(temp);
        }
        for(int i=0;i<matrix[0].length;i++){
            int temp=matrix[0][i];
            for(int j=0;j<matrix.length;j++){
                if(matrix[j][i] > temp){
                    temp=matrix[j][i];
                }
            }
            if(list.contains(temp)){
                list1.add(temp);
            }
        }
        return list1;
    }
}

