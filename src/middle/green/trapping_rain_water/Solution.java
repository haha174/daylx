package middle.green.trapping_rain_water;

class Solution {
//    public int trap(int[] height) {
//        int result=0;
//        int max=-1;
//        for (int i=0;i<height.length;i++){
//            max=Math.max(height[i],max);
//        }
//        for (int i=0;i<max;i++){
//            int left=-1;
//            for (int j=0;j<height.length;j++){
//               if (height[j]<=0){
//                   continue;
//               }
//               if (left>=0){
//                   result+= j-left-1;
//               }
//                left=j;
//                height[j]--;
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        int[] data={0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(new Solution().trap(data));
//    }

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}