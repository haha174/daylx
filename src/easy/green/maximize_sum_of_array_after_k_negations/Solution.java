package easy.green.maximize_sum_of_array_after_k_negations;

import java.util.Arrays;

class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int result=0;
        for (int i=0;i<A.length;i++){
            if (A[i]==0){
                K=0;
            }
            if (K-->0){
                A[i]=-A[i];
                if (i+1<A.length && A[i+1]>=Math.abs(A[i]) ){
                    i--;
                    continue;
                }
            }
            result+=A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {1,2,22,-23,-9,-30,-6,-9,1,8,24,2,21,29,10,-25,18,30,1,9,-8,-11,-22,-23,-17,-12,19,28,19,28};
        System.out.println(new Solution().largestSumAfterKNegations(data, 24));
    }
}