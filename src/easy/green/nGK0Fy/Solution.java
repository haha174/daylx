package easy.green.nGK0Fy;

import java.util.Arrays;

class Solution {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int cnt=0;
        int m=staple.length,n=drinks.length;
        int i=0,j=n-1;
        while(i<m&&j>=0){
            if(staple[i]+drinks[j]<=x){
                cnt=(cnt+j+1)%1000000007;
                i++;
            }else{
                j--;
            }
        }
        return cnt%1000000007;
    }
}
