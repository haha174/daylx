package easy.green.shuffle_the_array;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int index = 0;
//按照题意分别添加元素
        for(int i = 0;i < nums.length/2;i++){
            res[index++] = nums[i];
            res[index++] = nums[i + n];
        }
        return res;
    }
}
