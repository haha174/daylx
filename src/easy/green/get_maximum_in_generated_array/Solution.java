package easy.green.get_maximum_in_generated_array;

class Solution {
	public int getMaximumGenerated(int n) {
		int[] nums = new int[n + 1];
		if (n < 2) {
			return n;
		}
		nums[0] = 0;
		nums[1] = 1;
		int max = 1;
		for (int i = 2; i < nums.length; i++) {
			if (i % 2 == 0) {
				nums[i] = nums[i / 2];
			} else {
				nums[i] = nums[i / 2] + nums[i / 2 + 1];
			}
			max = Math.max(max, nums[i]);
		}
		return max;
	}
}
