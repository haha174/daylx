package middle.red.container_with_most_water;

class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int result=0;
        while (right>left){
            result=Math.max(result,(right -left)*Math.min(height[left],height[right]));
            if (height[left]>height[right]) right--;
            else left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data={1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(data));
    }
}