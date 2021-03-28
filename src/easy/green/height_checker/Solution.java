package easy.green.height_checker;

import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        int[] heightSoft=new int[heights.length];
        for (int i=0;i<heights.length;i++){
            heightSoft[i]=heights[i];
        }
        Arrays.sort(heightSoft);
        int result=0;
        for (int i=0;i<heights.length;i++){
           if ( heightSoft[i]!=heights[i]){
               result++;
           }
        }
    return result;
    }
}