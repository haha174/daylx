package middle.green.subarray_sum_equals_k;

import java.util.HashMap;

public class Solution {
//    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//        for (int start = 0; start < nums.length; ++start) {
//            int sum = 0;
//            for (int end = start; end <nums.length; end++) {
//                sum += nums[end];
//                if (sum == k) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }


        public int subarraySum(int[] nums, int k) {
            int count = 0, pre = 0;
            HashMap< Integer, Integer > mp = new HashMap < > ();
            mp.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (mp.containsKey(pre - k)) {
                    count += mp.get(pre - k);
                }
                mp.put(pre, mp.getOrDefault(pre, 0) + 1);
            }
            return count;
        }
}

