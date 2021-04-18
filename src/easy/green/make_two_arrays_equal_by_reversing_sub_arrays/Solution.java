package easy.green.make_two_arrays_equal_by_reversing_sub_arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length!=arr.length) return false;
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i=0;i<target.length;i++){
            if (target[i]!=arr[i]){
                return false;
            }
        }
        return true;
    }
}