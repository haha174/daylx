package before.remove_outermost_parentheses;

import java.util.Stack;

class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack=new Stack<>();
        char[] sArray=S.toCharArray();
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<sArray.length;i++){
            if (sArray[i]=='('){
                stack.push(sArray[i]);
                if (stack.size()==1){
                    continue;
                }

            }
            if (sArray[i]==')'){
                stack.pop();
                if (stack.size()==0){
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