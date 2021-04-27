package easy.green.find_nearest_point_that_has_the_same_x_or_y_coordinate;

class Solution {

    public int nearestValidPoint(int x, int y, int[][] points) {
    int lab=-1;//记录哈曼顿距离距离最小的下标
    int MinDistance=2147483647;//当前最小值
    for(int i=0;i<points.length;i++){
        if(points[i][0]==x||points[i][1]==y){
            if(MinDistance>(Math.abs(x-points[i][0])+Math.abs(y-points[i][1])))//判断最小值是否需要更新
            {
                MinDistance=(Math.abs(x-points[i][0])+Math.abs(y-points[i][1]));
                lab=i;
            }
        }
    }
    return lab;
    }
}
