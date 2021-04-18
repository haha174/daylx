package easy.green.count_largest_group;

import java.util.regex.Matcher;

class Solution {
    public int countLargestGroup(int n) {
        int[] resultTemp=new int[1000];
        int[] result=new int[1000];
        for (int i=1;i<=n;i++){
            int temp=0;
            int ti=i;
            while (ti>0){
                temp+=ti%10;
                ti/=10;
            }
            resultTemp[temp]++;
        }
        for (int i=0;i<resultTemp.length;i++){
            result[resultTemp[i]]++;
        }
        for (int i=result.length-1;i>0;i--){
           if (result[i]>0)return result[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countLargestGroup(13));
    }
}