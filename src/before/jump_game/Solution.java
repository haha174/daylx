package before.jump_game;

/**
 * 本题可以使用贪心算法求解
 */
public class Solution {
    public boolean canJump(int[] nums)
    {
        int n=nums.length;
        if(n==0)
            return false;
        int jump=nums[0];
        for(int i=1;i<n;i++)
        {
            jump--;
            if(jump<0)
                return false;
            jump=Math.max(jump,nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        int[] candidates = new int[]{3,2,1,0,4};
        System.out.println(new Solution().canJump(candidates));

    }

}