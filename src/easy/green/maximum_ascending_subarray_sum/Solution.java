package easy.green.maximum_ascending_subarray_sum;

class Solution {
    public int maxAscendingSum(int[] nums) {

        // result用来存放返回结果，初始值设置为 -1
        int result = -1;
        int len = nums.length;
        // i是逐步增大的
        for(int i = 0; i < len; i++){
            //从nums[i]开始寻找
            int k = nums[i];
            while(i + 1 < len && nums[i + 1] > nums[i]){
                k += nums[i + 1];
                i++;
            }
            
            //如果k大于result 则更新result
            if(k > result){
                result = k;
            }
        }
        return result;
    }
}
