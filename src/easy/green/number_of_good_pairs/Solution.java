package easy.green.number_of_good_pairs;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] cs = new int[101];
        int count = 0;
        //记录不同元素的重复数量
        for(int num : nums){
            cs[num] += 1;
        }
        for(int c :cs ){
            if(c > 1){
                // n 的方程
                count += (c*(c-1))/2;
            }
        }
        return count;
    }
}
