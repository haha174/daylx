package easy.green.remove_outermost_parentheses;

import java.util.Stack;

class Solution {
    public String removeOuterParentheses(String S) {
        int count=0;
        StringBuilder sb=new StringBuilder();
        char[] sArray=S.toCharArray();
        for (int i=0;i<sArray.length;i++){
            if (sArray[i]=='('){
                count++;
                if (count==1){
                    continue;
                }
            }
            if (sArray[i]==')'){
                count--;
                if (count==0){
                    continue;
                }
            }

            sb.append(sArray[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeOuterParentheses("(()())(())(()(()))"));
    }
}