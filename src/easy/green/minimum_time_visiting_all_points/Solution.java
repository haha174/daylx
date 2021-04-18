package easy.green.minimum_time_visiting_all_points;

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for (int i = 0 , j = i + 1; j < points.length; i++,j++) {
            int x = Math.abs(points[j][0] - points[i][0]);
            int y = Math.abs(points[j][1] - points[i][1]);
            sum += Math.max(y, x);
        }
        return sum;
    }
}