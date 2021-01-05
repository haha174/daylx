package before.trapping_rain_water;

public class Solution {
//    public int trap(int[] height) {
//        int n = height.length;
//        if (n < 3) {
//            return 0;
//        }
//        int result = 0;
//        int[] maxL = new int[n];
//        int[] maxR = new int[n];
//        for (int i = 1; i < n; i++) {
//            maxL[i] = Math.max(maxL[i - 1], height[i - 1]);
//            maxR[n - i - 1] = Math.max(maxR[n - i], height[n - i]);
//        }
//
//        for (int i = 0; i < n; i++) {
//            int ht = Math.min(maxL[i], maxR[i]);
//            if (ht > height[i]) {
//                result += ht - height[i];
//            }
//        }
//        return result;
//    }
public int trap(int[] height) {

    int l = 0;
    int r = height.length - 1;
    int minl = 0;
    int minr = 0;
    int a = 0;
    while (l < r) {
        if (height[l] < height[r]) {
            if (minl > height[l]) {
                a += minl - height[l];
            } else {
                minl = height[l];
            }
            l++;

        } else {
            if (minr > height[r]) {
                a += minr - height[r];
            } else {
                minr = height[r];
            }
            r--;

        }


    }
    return a;


}
    public static void main(String[] args) {
        int[] arr={2,0,2};
        System.out.println(new Solution().trap(arr));
    }
}