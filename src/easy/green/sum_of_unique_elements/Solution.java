package easy.green.sum_of_unique_elements;

class Solution {
    public int sumOfUnique(int[] nums) {
        int[] count = new int[101];
        for (int i=0;i<nums.length;i++){
        count[nums[i]]=count[nums[i]]+1;
        }
        //此处定义一个空数组count长度为101内容全为0，
        //nums数组中输入什么数(one)，count数组的第one位就
        //会变为1，若输入的数相同，有几个相同的数，count数组
        //的第one位就会变为几
        int res = 0;
        for (int i = 1; i < 101; i++) {
            if (count[i] == 1){    //if (count[i] == 2){
                res =res+ i;     //res =res+ i*2;}出现两次
            }
        }
        //此处判断nums数组中输入数的次数，count[i] == 1就表示
        //这个数出现了一次，count[i] == 2就表示这个数出现了二次
        //且count[i] == 1中的i就是nums数组中的元素
        return res;
    }
}
