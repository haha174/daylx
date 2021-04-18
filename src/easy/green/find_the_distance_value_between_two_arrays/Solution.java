package easy.green.find_the_distance_value_between_two_arrays;

import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int hi = arr2.length - 1;
        int count = 0;
        for(int i : arr1){
            int index = binarySearch(arr2, 0, hi, i);
            if(index == 0){
                if(Math.abs(arr2[index] - i) > d)
                    count++;
            } else if(index == hi + 1) {
                if(Math.abs(arr2[hi] - i) > d)
                    count++;
            } else {
                if(Math.abs(arr2[index] - i) > d && Math.abs(arr2[index - 1] - i) > d)
                    count++;
            }
        }
        return count;
    }

    private int binarySearch(int[] arr, int lo, int hi, int target){
        while(lo <= hi){
            int mid = (hi - lo) / 2 + lo;
            if(arr[mid] < target) lo = mid + 1;
            else if(arr[mid] > target) hi = mid - 1;
            else return mid;
        }
        return lo;
    }
}