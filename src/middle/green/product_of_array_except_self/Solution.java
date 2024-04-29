package middle.green.product_of_array_except_self;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        int L[]=new int[nums.length];
        int R[]=new int[nums.length];
        L[0]=1;
        R[nums.length-1]=1;
        for (int i=0;i<nums.length-1;i++){
            L[i+1]=L[i]*nums[i];
            int j=nums.length-1-i;
            R[j-1]=R[j]*nums[j];
        }

        for (int i=0;i<nums.length;i++){
           answer[i]=L[i]*R[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int data[]={1,2,3,4};
        System.out.println(new Solution().productExceptSelf(data));
    }
}
