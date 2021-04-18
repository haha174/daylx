package easy.green.the_k_weakest_rows_in_a_matrix;

import java.util.Arrays;

class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            int[] list = new int[mat.length];
            int[] result = new int[k];
            for(int i=0;i<mat.length;i++){
                list[i] = count(mat[i])*100+i;
            }
            Arrays.sort(list);
            for(int i=0;i<k;i++){
                result[i] = list[i]%100;
            }
            return result;
        }

        public int count(int[] nums){
            int sum=0;
            for(int n:nums){
                if(n!=1){
                    break;
                }
                sum+=n;
            }
            return sum;
        }
    }
