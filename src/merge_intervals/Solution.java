package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) {
            return intervals;
        }
        int m = 0;

        outer: for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (canMerge(intervals, i, j)) {
                    intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
                    intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
                    intervals[i] = null;
                    continue outer;
                }
            }
            m++;
        }
        int[][] ans = new int[m][2];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (intervals[i] != null) {
                ans[j++] = intervals[i];
            }
        }
        return ans;
    }

    public boolean canMerge(int[][] a, int i, int j) {
        return Math.max(a[i][0], a[j][0]) <= Math.min(a[i][1], a[j][1]);
    }

//
//    public static int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
//        ArrayList<int[]> result = new ArrayList<>();
//        if (intervals.length == 0) {
//            return result.toArray(new int[result.size()][0]);
//        }
//        result.add(intervals[0]);
//        for (int i = 1; i < intervals.length; i++) {
//            int[] arr = result.get(result.size() - 1);
//            if (intervals[i][0] <= arr[1]) {
//                arr[1] = Math.max(arr[1],intervals[i][1]);
//            } else {
//                result.add(intervals[i]);
//            }
//        }
//        return result.toArray(new int[result.size()][2]);
//    }

    public static void main(String[] args) {
        int[][] data = {{1, 4}, {2, 5}, {6, 7}, {2, 5}, {2, 5}, {2, 5}};
        new Solution().merge(data);
    }
}