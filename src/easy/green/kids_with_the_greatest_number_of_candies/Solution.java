package easy.green.kids_with_the_greatest_number_of_candies;
import java.util.*;
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < candies.length;i++){
            if(candies[i] > max){
                max = candies[i];
            }
        }
        List<Boolean> list = new ArrayList<>();
        for(int i = 0;i < candies.length;i++){
            if(candies[i] + extraCandies >= max){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        return list;
    }
}
