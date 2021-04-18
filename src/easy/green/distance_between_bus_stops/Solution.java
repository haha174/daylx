package easy.green.distance_between_bus_stops;

class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        // 通过mark来区分两点间的正反路径
        int mark = 0;
        int[] sum = new int[2];
        for (int i = 0; i < n; i++) {
            if (i==start || i == destination) {
                mark = mark == 0?1:0;
            } 
            sum[mark] += distance[i];
        }
        return Math.min(sum[0], sum[1]);
    }
}

