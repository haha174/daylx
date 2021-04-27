package easy.green.largest_substring_between_two_equal_characters;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        char[] sArray=s.toCharArray();
        int result=-1;
        for (int i=0;i<sArray.length;i++){
            for (int j=sArray.length-1;j>i;j--){
                if (sArray[i]==sArray[j]){
                    result=Math.max(j-i-1,result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxLengthBetweenEqualCharacters("abca"));
    }
}