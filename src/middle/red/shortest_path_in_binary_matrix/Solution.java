package middle.red.shortest_path_in_binary_matrix;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int[] X = {0,1,1,1,0,-1,-1,-1};//方向数组
    private int[] Y = {1,1,0,-1,-1,-1,0,1};
    private int m,n;//方便记录长度而已，本题其实m和n是相等的。
    public int shortestPathBinaryMatrix(int[][] grid) {
        m = grid.length; n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;//特殊情况特殊考虑，出口和入口被堵死
        if(m == 1 && grid[0][0] ==0) return 1;//只有一个0的情况
        int[][] v = new int[m][n];//识别数组
        Queue<int[]> a = new LinkedList();//队列，里面保存int数组为坐标
        a.add(new int[]{0,0});//一开始将起点入队
        v[0][0] = 1;//起点标记为已经访问
        int step = 1;//理论上的初值
        while (!a.isEmpty()){
            int s =  a.size();//为step叠加用
            for (int i = 0; i < s;i++){
                int[] temp = a.poll();//poll()方法会自动获取队首元素，且获取完自动出队
                int x = temp[0];
                int y = temp[1];
                for(int j=0;j<8;j++){
                    int x1 = x + X[j];
                    int y1 = y + Y[j];
                    if(x1>=0 && x1<m && y1>=0 && y1<n && grid[x1][y1]==0 && v[x1][y1]!=1){//数组不越界，值为1，//没有被访问过才能入队
                        a.add(new int[]{x1,y1});//入队
                        v[x1][y1] = 1;//标记已访问！！！！！！！！！！！！不要忘记
                    }
                }
                if(x==m-1 && y==n-1) return step;//终止条件
            }
            step++;
        }
        return -1;//队列为空即为不能到达终点，返回-1
    }
}
