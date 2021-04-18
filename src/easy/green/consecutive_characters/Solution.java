package easy.green.consecutive_characters;

class Solution {
    public int maxPower(String s) {
        if (s==null || s.length()==0) return 0;
        char[] sArr=s.toCharArray();
        char pre=sArr[0];
        int max=1;
        int temp=1;
        for (int i=1;i<sArr.length;i++){
            if (sArr[i]!=pre){
                pre=sArr[i];
                if (temp>max) max=temp;
                temp=1;
            }else {
                temp++;
            }
        }
        if (temp>max) max=temp;
        return max;
    }
}