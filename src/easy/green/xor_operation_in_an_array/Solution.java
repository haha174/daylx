package easy.green.xor_operation_in_an_array;

class Solution {
    public int xorOperation(int n, int start) {
        int[] a=new int[n];   
        for(int i=0;i<a.length;i++){
            a[i] = start + 2*i;
        }
        int res=a[0];
        for(int i=1;i<a.length;i++){
            res ^= a[i];
        }
        return res;
    }
}
