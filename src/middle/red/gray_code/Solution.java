package middle.red.gray_code;
import java.util.*;
class Solution {
    /**
     * 要求：格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
     * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。格雷编码序列必须以 0 开头。
     *
     * @param n 输入的非负整数n，int类型
     * @return 格雷码序列，List<Integer>类型
     * 方法：镜像对称方式
     * n=1时，
     * 0 -- 0
     * 1 -- 1
     * n=2时，将n=1时的结果镜像对称，然后上半部分后续添加0，转化为十进制则是上半部分的值乘2；下半部分后续添加1，转化为十进制就是下半部分的值乘2加1
     * 0 0 -- 0
     * 1 0 -- 2
     * 1 1 -- 3
     * 0 1 -- 1
     * n=3时，将n=2时的结果镜像对称，然后上半部分后续添加0，转化为十进制则是上半部分的值乘2；下半部分后续添加1，转化为十进制就是下半部分的值乘2加1
     * 0 0 0 -- 0
     * 1 0 0 -- 4
     * 1 1 0 -- 6
     * 0 1 0 -- 2
     * 0 0 1 -- 1
     * 1 0 1 -- 5
     * 1 1 1 -- 7
     * 0 1 1 -- 3
     */
    public static List<Integer> grayCode(int n) {
        // 结果数组
        List<Integer> res = new ArrayList<>();
        res.add(0);
        // 判断边界情况
        if (n < 1) {
            return res;
        }
        // 将1添加进去，此时对应n为1
        res.add(1);
       // 结果数组的当前大小
        int size;
        // 临时变量用于镜像计算
        int temp;
        // 从n=2的情况开始遍历
        for (int i = 2; i <= n; i++) {
            size = res.size();
            // 镜像计算
            for (int j = size - 1; j >= 0; j--) {
                temp = res.get(j) * 2;
                // 对应的下半部分，这里还没有初始值，续调添加新的进去
                res.add(temp + 1);
                // 对应的上半部分，这里已经有初始值，需要修改
                res.set(j, temp);
            }
        }
        return res;
    }
}
