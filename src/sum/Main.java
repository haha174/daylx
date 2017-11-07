package sum;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String args[]) {

		int[] nums= {0,2, 7, 11, 15};
		int target = 15;
		long start=new Date().getTime();
		int[] result=new Solution().twoSum(nums, target);
		System.out.println(new Date().getTime()-start);
		System.out.println(Arrays.toString(result));
	}
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int[] result =new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])) {
            	result[0]=map.get(target-nums[i]);
            	result[1]=i;
            }else {
            	map.put(nums[i], i);
            }
        }
        return result;
    }
}
