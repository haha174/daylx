package middle.green.kth_largest_element_in_an_array;

class Solution {
//    public int findKthLargest(int[] nums, int k) {
//        int[] buckets = new int[20001];
//        for (int i = 0; i < nums.length; i++) {
//            buckets[nums[i] + 10000]++;
//        }
//        for (int i = 20000; i >= 0; i--) {
//            k = k - buckets[i];
//            if (k <= 0) {
//                return i - 10000;
//            }
//        }
//        return 0;
//    }

    int quickselect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
       if (k <= j) return quickselect(nums, l, j, k);
        else return quickselect(nums, j + 1, r, k);
    }

    public int findKthLargest(int[] _nums, int k) {
        int n = _nums.length;
        return quickselect(_nums, 0, n - 1, n - k);
    }

    public static void main(String[] args) {
        int[] data={3,2,1,5,6,4};
        int result=new Solution().findKthLargest(data,2);
        System.out.println(result);
    }
}

