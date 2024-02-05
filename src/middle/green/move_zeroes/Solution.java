package middle.green.move_zeroes;

class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j<nums.length) {
            if (nums[j]!=0){
                int tmp=nums[j];
                nums[j]=nums[i];
                nums[i]=tmp;
                i++;
            }
            j++;

        }
    }

    public static void main(String[] args) {
        int[] arr = {3,0,1, 0, 12};
        new Solution().moveZeroes(arr);
        System.out.println(arr);
    }
}