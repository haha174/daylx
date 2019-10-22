package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        ArrayList<int[]> arr = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] a = new int[2];
            if (arr.isEmpty()) {
                arr.add(new int[]{intervals[i][0], intervals[i][1]});
            } else {
                a = arr.get(arr.size() - 1);
                if (a[1] >= intervals[i][0]) {
                    a[1] = Math.max(a[1], intervals[i][1]);
                } else {

                    arr.add(new int[]{intervals[i][0], intervals[i][1]});
                }
            }
        }
        return arr.toArray(new int[arr.size()][2]);
    }


}