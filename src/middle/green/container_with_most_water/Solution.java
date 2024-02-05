package middle.green.container_with_most_water;

class Solution {
    public int maxArea(int[] height) {
        int result=0;
        int i=0,j=height.length-1;
        while (i<j){
            result=height[i]>height[j]?Math.max((j-i)*height[j--],result):Math.max((j-i)*height[i++],result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(arr));
    }
}