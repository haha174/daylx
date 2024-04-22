package middle.green.rotate_array;

class Solution {
    public void rotate(int[] nums, int k) {
        int[] result=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            result[(i+k)%nums.length]=nums[i];
        }
        for (int i=0;i<nums.length;i++){
            nums[i]=result[i];
        }
    }

    public static void main(String[] args) {
        int[] data={1,2,3,4,5,6,7};
        new Solution().rotate(data,2);
        System.out.println();
    }
}