package before.third_maximum_number;

/**
 *
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 *
 */
class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length==1)return nums[0];
        long a=Long.MIN_VALUE,b=Long.MIN_VALUE,c=Long.MIN_VALUE;
        //for(int n : nums) 循环比 for (int i;i<n;i++) 要快
        for(int n : nums){
            if (n>a){
                c=b;
                b=a;
                a=n;
            }else if (n<a &&n>b){
                c=b;
                b=n;
            } else if (n<b &&n>c){
                c=n;
            }
        }
        if (nums.length==2||c==Long.MIN_VALUE){
            return (int)a;
        }
        return (int)c;
    }

    public static void main(String[] args) {
        int[] data={3,2,  1};
        System.out.println(new Solution().thirdMax(data));
    }
}