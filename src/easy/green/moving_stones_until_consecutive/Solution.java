package easy.green.moving_stones_until_consecutive;

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int max=Math.max(a,b);
         max=Math.max(max,c);
        int min=Math.min(a,b);
        min=Math.min(min,c);
        int[] res=new int[2];
        res[1]=max-min-2;
        if (max-min==2){
            res[0]=0;
        } else if (Math.abs(a-b)<=2 || Math.abs(a-c)<=2|| Math.abs(c-b)<=2){
            res[0]=1;
        }else {
            res[0]=2;
        }
        return res;
    }
}