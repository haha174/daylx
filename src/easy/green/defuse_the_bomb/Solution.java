package easy.green.defuse_the_bomb;

class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] newCode = new int[code.length];   //新数组，用来存放答案
        if (k == 0) {
            return newCode;
        }
        int offset = k > 0 ? 0 : code.length + k - 1;   //偏移量，当K是负数的时候，要等价代换一下
        k = k > 0 ? k : -k; //对K取绝对值
        for (int i = 0 + offset; i < code.length + offset; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += code[(i + 1 + j) % code.length];//通过取余就可以实现循环操作
            }
            newCode[i - offset] = sum;  //对0-n-1下标的新数组赋值
        }
        return newCode;
    }
}

