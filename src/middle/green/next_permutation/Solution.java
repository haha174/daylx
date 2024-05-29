package middle.green.next_permutation;

class Solution {
    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        if (i < 0) {
            // 如果i 小于0 说明整个数据是降序的反转整个数据
            reverse(nums, i + 1, nums.length - 1);
            return;
        } else {
            //后则的话只需要改动最后一个升序即可  先找到第一个比他大的数字
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, j, i);
                    reverse(nums, i + 1, nums.length - 1);
                    break;
                }
            }
        }
    }

    private void reverse(int[] nums, int x, int y) {
        int end = y;
        for (int i = x; i <= (y + x) / 2; i++) {
            swap(nums, i, end--);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] a={5,4,1,3,2};
        new Solution().nextPermutation(a);
        for(int i=0;i<a.length;i++ ){
            System.out.print(a[i]+" ");
        }
    }
}