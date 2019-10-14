package n_queens;

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
    //    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> result=new ArrayList<>();
//        char[][] data= new char[n][n];
//        for (int i=0;i<n;i++){
//            for (int j=0;j<n;j++){
//                data[i][j]='.';
//            }
//        }
//        solveNQueen(result, data,0,n);
//        return result;
//    }
//
//
//    public void solveNQueen(List<List<String>> result,char[][] temp,int index,int n) {
//           if (index==n){
//               addResult(result,temp,n);
//           } else{
//               for (int i=0;i<n;i++){
//                   if(checkIfMatch(temp,index,i,n)){
//                       temp[index][i]='Q';
//                       solveNQueen(result,temp,index+1,n);
//                       temp[index][i]='.';
//                   }
//               }
//           }
//    }
//    public void addResult(List<List<String>> result,char[][] data,int n){
//        List<String> temp=new ArrayList<>();
//        for (int i=0;i<n;i++){
//            temp.add(new String(data[i]));
//        }
//        result.add(temp);
//
//
//    }
//    public boolean checkIfMatch(char[][] data,int line,int column,int n){
//        for (int i=0;i<line;i++){
//            if(data[i][column]=='Q'){
//                return false;
//            }else if ((column+(line-i)<n&&data[i][column+(line-i)]=='Q')||(column-(line-i)>=0&&data[i][column-(line-i)]=='Q')){
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     * time:1ms
     */
    List resultList = new ArrayList<List<String>>();
    int[] cols;
    int[] left;
    int[] right;
    int n;

    public List<List<String>> solveNQueens(int n) {
        char[][] trace = new char[n][n];
        this.cols = new int[n];
        this.left = new int[2 * n - 1];
        this.right = new int[2 * n - 1];
        this.n = n;
        char[] tmp = new char[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) trace[i][j] = '.';
        }
        search(trace, 0);
        return resultList;

    }

    public void search(char[][] trace, int depth) {
        if (depth == n) {
            List<String> tmp = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                tmp.add(String.valueOf(trace[i]));
            }
            resultList.add(tmp);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (cols[j] == 1 || left[j - depth + n - 1] == 1 || right[j + depth] == 1) continue;
            trace[depth][j] = 'Q';
            cols[j] = 1;
            left[j - depth + n - 1] = 1;
            right[j + depth] = 1;
            depth += 1;
            search(trace, depth);
            depth -= 1;
            right[j + depth] = 0;
            left[j - depth + n - 1] = 0;
            cols[j] = 0;
            trace[depth][j] = '.';
        }
        return;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
        ;
    }
}