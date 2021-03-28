package easy.green.duplicate_zeros;

class Solution {
    public void duplicateZeros(int[] arr) {
        int[] arrDu=new int[arr.length];
        int zeroCount=0;
        for (int i=0;i<arr.length;i++){
            arrDu[i]=arr[i];
        }
        int index=0;
        for (int i=0;i<arrDu.length&& index<arrDu.length;i++){

             if(arrDu[i]==0){
                 arr[index++]=0;
                 if (index<arrDu.length){
                     arr[index++]=0;
                 }
             }else {
                 arr[index++]=arrDu[i];
             }
        }
    }

    public static void main(String[] args) {
        int data[]={9,0,9,0,6,0,0,0,1,1,6,5,4,4,8,3,0,0,0,1,5,3,0,0,7,2,1,0,2,0,9,1,0,2,0,0,0,0,0,0,0,6,0,0,7,9,0,8,7,0,9,7,1,0,2,0,0,0,0,9,0,0,0,0};
        new Solution().duplicateZeros(data);
    }
}