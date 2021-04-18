package easy.green.cells_with_od_dvalues_in_a_matrix;

class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] a=new int[m][n];
        for(int i=0;i<indices.length;i++){
            int h= indices[i][0];
            int l= indices[i][1];
            for(int z=0;z<a.length;z++){
                for(int zz=0;zz<a[z].length;zz++){
                    if(z==h){
                        a[z][zz]++;
                    }
                    if(zz==l){
                        a[z][zz]++;
                    }
                }
            }
        }
        int res=0;
        for(int z=0;z<a.length;z++){
            for(int zz=0;zz<a[z].length;zz++){
                if(a[z][zz] %2 !=0){
                    res++;
                }
            }
        }
        return res;
    }
}
