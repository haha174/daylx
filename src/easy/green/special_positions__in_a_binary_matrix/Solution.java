package easy.green.special_positions__in_a_binary_matrix;

class Solution {
    int count=0;
    public int numSpecial(int[][] mat) {
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                if(mat[i][j] == 1){
                    // 每次记录传输的原地址 只要所有的没有1则
                    if(temp1(mat,i+1,i,j)&&temp1(mat,i-1,i,j)&&temp2(mat,i,j-1,j)&&temp2(mat,i,j+1,j)){
                        count++;
                    }
                }
                
            }
        }
        return count;
    }
    
    public boolean temp1(int[][] mat,int i,int index,int j){
        
        if(i<0 || i>mat.length-1) return true;
        if(mat[i][j] == 1) return false;
        return index>i?temp1(mat,i-1,index,j):temp1(mat,i+1,index,j);
    }
    public boolean temp2(int[][] mat,int i,int j,int index){
        
        if(j<0 || j>mat[i].length-1) return true;
        if(mat[i][j] == 1) return false;
        return index>j?temp2(mat,i,j-1,index):temp2(mat,i,j+1,index);
    }
}