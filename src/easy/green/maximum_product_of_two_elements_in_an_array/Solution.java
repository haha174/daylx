package easy.green.maximum_product_of_two_elements_in_an_array;

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int max1 = 0, max2 = 0; //max1为最大值,max2为次大值
        for (int num : nums) {
            if (num > max1) {    //若num大于之前的最大值,则现在最大值是num,次大值是max1
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
}