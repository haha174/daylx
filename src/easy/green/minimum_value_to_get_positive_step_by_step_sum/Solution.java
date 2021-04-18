package easy.green.minimum_value_to_get_positive_step_by_step_sum;

class Solution {
    public int minStartValue(int[] nums) {
       int sum = 0;
       int min = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length;++i){
           sum += nums[i];
           if (min>sum){
               min=sum;
           }
        }
        if (min<0){
            return 1-min;
        }else {
            return 1;
        }
    }
}
