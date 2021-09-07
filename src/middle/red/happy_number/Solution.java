package middle.red.happy_number;

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> visit=new HashSet<>();
    public boolean isHappy(int n) {
        int sum=0;
        while (n>0){
            int temp=n%10;
            sum+=temp*temp;
            n=n/10;
        }
        if (sum==1) return true;
        if (visit.contains(sum)) return false;
        visit.add(sum);
        return isHappy(sum);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(2));
    }
}