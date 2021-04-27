package easy.green.sign_of_the_product_of_an_array;

class Solution {
    public int arraySign(int[] nums) {
        //记录负数的个数
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            } else {
                if (nums[i] < 0) {
                    c++;
                }
            }
        }
        //判断负数是偶数个还是奇数个
        if ((c & 1) == 0) {
            return 1;
        } else {
            return -1;
        }
    }
}