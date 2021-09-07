package middle.red.generate_parentheses;

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        if (n>0){
            generateParenthesis(result,new StringBuilder(),0,0,n);
        }
        return result;
    }
    private void generateParenthesis(List<String> result,StringBuilder sb,int left,int right,int n) {
        if (sb.length()==n*2){
            result.add(sb.toString());
        }
        if (left<n && left>=right){
           sb.append("(");
            generateParenthesis(result,sb,left+1,right,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right<=left){
            sb.append(")");
            generateParenthesis(result,sb,left,right+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}