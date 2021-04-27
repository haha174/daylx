package easy.green.maximum_number_of_balls_in_a_box;

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int k = 0, t = lowLimit;
        while(t > 0) {  //计算lowLimit的数位和
            k += t%10;
            t /= 10;
        }
        int[] map = new int[50];    //数位和不可能超过45（最大为99999）
        int res = 0;
        for(int i = lowLimit; i <= highLimit; ++i) {
            res = Math.max(res, ++map[k]);  //每次求出盒子编号后顺便求出最大值
            t = i;
            while(t % 10 == 9) {    //上一个盒子编号的中需要进位
                k -= 9;             //比如上一个数199那么依次把进位的9减去
                t /= 10;            //可以理解为199->100
            }
            ++k;                    //需要进位的话可以理解为100->200
        }                           //若不需要进位123->124,单纯自增
        return res;
    }
}
