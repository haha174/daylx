package number_of_boomerangs;

import java.util.HashMap;

/**
 *
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 * Example:
 *
 * Input:
 * [[0,0],[1,0],[2,0]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 *
 */
class Solution {
//    public int numberOfBoomerangs(int[][] points) {
//        int result=0;
//        Map<Integer,Integer> dataMap=new HashMap<>();
//        for (int i=0;i<points.length;i++){
//            int x = points[i][0];
//            int y = points[i][1];
//            dataMap.clear();
//            for (int j=0;j<points.length;j++){
//                if (i==j) continue;
//                int des= (x - points[j][0]) * (x - points[j][0]) + (y - points[j][1]) * (y - points[j][1]);
//                dataMap.put(des,dataMap.getOrDefault(des,0)+1);
//            }
//            Iterator<Map.Entry<Integer,Integer>> ite=  dataMap.entrySet().iterator();
//            while (ite.hasNext()){
//                int value=ite.next().getValue();
//                result+=value*(value-1);
//            }
//        }
//        return result;
//    }

public int numberOfBoomerangs(int[][] points) {
    int total = 0;
    for (int i = 0; i < points.length; ++i) {
        int x = points[i][0];
        int y = points[i][1];
        HashMap<Integer, Integer> distances = new HashMap<>();
        for (int j = 0; j < points.length; ++j) {
            if (j == i) continue;

            Integer currDistance =
                    (x - points[j][0]) * (x - points[j][0]) + (y - points[j][1]) * (y - points[j][1]);
            if (!distances.containsKey(currDistance)) {
                distances.put(currDistance, 1);
            } else {
                int count = distances.get(currDistance);
                total += 2 * count;
                distances.put(currDistance, count + 1);
            }
        }
    }
    return total;
}
    public static void main(String[] args) {
        //[[0,0],[1,0],[-1,0],[0,1],[0,-1]]
        int data[][]={{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        System.out.println(new Solution().numberOfBoomerangs(data));
    }
}