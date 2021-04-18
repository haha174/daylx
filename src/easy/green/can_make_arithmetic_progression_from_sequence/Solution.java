package easy.green.can_make_arithmetic_progression_from_sequence;

import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
//计算差
        int n = arr[1] - arr[0];
//如果不相等就直接退出
        for(int i = 0;i < arr.length - 1;i++){
            if(arr[i+1] - arr[i] != n){
                return false;
            }
        }
        return true;
    }
}
