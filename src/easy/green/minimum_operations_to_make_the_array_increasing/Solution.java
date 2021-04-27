package easy.green.minimum_operations_to_make_the_array_increasing;

class Solution {
    public int minOperations(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int res=0;
        for(int i = 0;i < nums.length - 1;i++){
            //如果下一个比这个大了,就让res + 大的部分再加一,保证要比这个大
            if(nums[i + 1] <= nums[i]){
                res += nums[i] -  nums[i + 1] + 1;
            //然后让下一个变成改变后的值
                nums[i+1] +=  nums[i] -  nums[i + 1] + 1;
            }
        }
        return res;
    }
}
