package middle.green.single_number_iii;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private int anInt;

    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
//                anInt;
            }
        }
        return ans;
    }
}