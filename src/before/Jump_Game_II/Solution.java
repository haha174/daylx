package before.Jump_Game_II;

public class Solution {
    public int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                System.out.println(i);
                curEnd = curFarthest;
            }
        }
        return jumps;
    }


    public static void main(String[] args) {
        int[] arr={1,2,2,0,0,10,1,1,1,1,1,1,1,1};
        System.out.println(new Solution().jump(arr));
    }
}