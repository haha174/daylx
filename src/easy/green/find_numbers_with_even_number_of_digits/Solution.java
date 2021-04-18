package easy.green.find_numbers_with_even_number_of_digits;

class Solution {
    public int findNumbers(int[] nums) {
        int res=0;
        int tmp=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<10){
                continue;
            }
            if(nums[i]>10){
                while(nums[i]/10 > 0){
                    tmp++;
                    nums[i]=nums[i]/10;
                }
                if(tmp % 2 ==0){
                    res++;
                }
            }
            tmp=1;
        }
        return res;
    }
}
