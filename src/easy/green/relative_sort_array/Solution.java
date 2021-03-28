package easy.green.relative_sort_array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for(int i = 0;i < arr1.length;i++){
            if(max < arr1[i]){
                max = arr1[i];
            }
        }
//这个数组记录x的次数
        int[] frequency = new int[max + 1];
        for(int x : arr1){
            frequency[x]++;
        }
        int[] res = new int[arr1.length];
        int index = 0;
        for(int x : arr2){
            for(int i = 0;i < frequency[x];i++){
                res[index++] = x;
            }
            frequency[x] = 0;
        }
        for(int x = 0;x <= max;x++){
            for(int i = 0;i < frequency[x];i++){
                res[index++] = x;
            }
        }
        return res;
    }
}
