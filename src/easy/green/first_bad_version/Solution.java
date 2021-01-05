package easy.green.first_bad_version;
/**
 * 二分查找
 */
//public class Solution {
//    int n=0;
//    public int firstBadVersion(int n) {
//        int left = 1;
//        int right = n;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (isBadVersion(mid)) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }
//}