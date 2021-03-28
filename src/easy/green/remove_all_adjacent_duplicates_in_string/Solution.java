package easy.green.remove_all_adjacent_duplicates_in_string;

class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for(char ch : S.toCharArray()){
            if(len > 0 && sb.charAt(len - 1) == ch){
                sb.deleteCharAt(len - 1);
                len--;
            }
            else{
                sb.append(ch);
                len++;
            }
        }
        return sb.toString();
    }
}