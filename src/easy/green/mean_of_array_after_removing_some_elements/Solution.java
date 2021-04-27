package easy.green.mean_of_array_after_removing_some_elements;

import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {
        double res = 0.0;
        Arrays.sort(arr);
        int sum = 0;
        for(int i = arr.length/20;i < arr.length - arr.length/20;++i){
            sum += arr[i];
        }
        res = sum/(arr.length*0.90);
        return res;
    }
}

