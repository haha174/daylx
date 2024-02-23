package middle.red.trapping_rain_water;

class Solution {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxl = 0;
        int maxr = 0;
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (maxl > height[left]) {
                    result += maxl - height[left];
                } else {
                    maxl = height[left];
                }
                left++;

            } else {
                if (maxr > height[right]) {
                    result += maxr - height[right];
                } else {
                    maxr = height[right];
                }
                right--;

            }


        }
        return result;
    }

    public static void main(String[] args) {
        int[] data={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution().trap(data));
    }
}