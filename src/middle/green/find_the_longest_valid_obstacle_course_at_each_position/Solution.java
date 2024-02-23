package middle.green.find_the_longest_valid_obstacle_course_at_each_position;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        List<Integer> ls = new ArrayList<>();
        int n = obstacles.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            int x = obstacles[i];
            // 寻找第一个大于obstacles[i]的位置
            int l = 0, r = ls.size();
            while (l < r) {
                int mid = l + r >> 1;
                if (ls.get(mid) <= x) {
                    l = mid + 1;
                } else {
                    r = mid;
                }

            }
            if (l == ls.size()) {
                ls.add(x);
            } else {
                ls.set(l, x);
            }
            ans[i] = l + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 6, 4, 2};
        System.out.println(new Solution().longestObstacleCourseAtEachPosition(arr));
    }
}