package easy.green.how_many_numbers_are_smaller_than_the_current_number;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if(nums==null||nums.length<=1){
            return nums;
        }
        int[] newNums = new int[nums.length];
        int n = nums.length;
        int[] counter=new int[101];
        for (  int i = 0; i < n; i++ ) {
            counter[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++ ){
            counter[i] +=counter[i-1];
        }
        for( int i = 0; i < n; i++ ){
            newNums[i]=nums[i]==0?0:counter[nums[i]-1];
        }
        return newNums;
    }
}