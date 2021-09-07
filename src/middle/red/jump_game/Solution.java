package middle.red.jump_game;

class Solution {
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


    }