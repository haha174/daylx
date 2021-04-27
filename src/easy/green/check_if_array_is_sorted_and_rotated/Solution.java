package easy.green.check_if_array_is_sorted_and_rotated;

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        //有经过轮转
        boolean isCount = nums[0] >= nums[n-1];
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                if(isCount){
                    isCount = false;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
