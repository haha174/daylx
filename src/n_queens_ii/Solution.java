package n_queens_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * time:3ms
 */
//class Solution {
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> result=new ArrayList<>();
//        solveNQueen(result,new ArrayList<>(),n);
//        return result;
//    }
//
//
//    public void solveNQueen(List<List<String>> result,List<Integer> temp,int n) {
//        if (temp.size()==n){
//            addResult(result,temp,n);
//        } else{
//            for (int i=0;i<n;i++){
//                if(checkIfMatch(temp,i)){
//                    temp.add(i);
//                    solveNQueen(result,temp,n);
//                    temp.remove(temp.size()-1);
//                }
//            }
//        }
//    }
//    public void addResult(List<List<String>> result,List<Integer> solution,int n){
//        char[][] data=new char[n][n];
//        List<String> temp=new ArrayList<>();
//        for (int i=0;i<n;i++){
//            for (int j=0;j<n;j++){
//                data[i][j]='.';
//            }
//        }
//        for (int i=0;i<solution.size();i++){
//            data[i][solution.get(i)]='Q';
//        }
//        for (int i=0;i<solution.size();i++){
//            temp.add(new String(data[i]));
//        }
//        result.add(temp);
//
//
//    }
//    public boolean checkIfMatch(List<Integer> temp,int value){
//        int index=temp.size();
//        for (int i=0;i<temp.size();i++){
//            if(temp.get(i)==value){
//                return false;
//            }else if (temp.get(i)==value+(index-i)){
//                return false;
//            }else if (temp.get(i)==value-(index-i)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//}
class Solution {
    /**
     * time:2ms
     */
    public int totalNQueens(int n) {
        int[] array = new int[n];
        return solveNQueen(array, 0);
    }


    private int solveNQueen(int[] array, int row) {
        if (row == array.length) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[row] = i;
            if (isValid(array, row)) {
                sum += solveNQueen(array, row + 1);
            }
        }
        return sum;
    }

    private boolean isValid(int[] array, int row) {
        for (int i = row; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j] || array[i] - array[j] == i - j || array[i] - array[j] == j - i) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().totalNQueens(4));
        ;
    }
}