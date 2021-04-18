package easy.green.find_n_unique_integers_sum_up_to_zero;

class Solution {
    public int[] sumZero(int n) {
            int[] a=new int[n];
            if(n%2!=0){
                int mid = n/2;
                a[mid]=0;
                int j=0,z=1;
                while(j<mid){
                    a[j]=-z;
                    a[j+mid+1]=z;
                    z++;
                    j++;
                }
            }else{
                int j=0,jj=a.length-1,z=1;
                while(j<jj){
                    a[j]=z;
                    a[jj]=-z;
                    j++;
                    jj--;
                    z++;
                }
            }
            return a;
    }
}
