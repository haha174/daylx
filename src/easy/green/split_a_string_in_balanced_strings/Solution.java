package easy.green.split_a_string_in_balanced_strings;

class Solution {
    public int balancedStringSplit(String s) {
        int count=0;
        int sumR=0;int sumL=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='R'){
                sumR++;
            }else{
                sumL++;
            }
            if(sumR==sumL){
                count++;
                sumR=0;
                sumL=0;
            }
        }
        return count;
    }
}