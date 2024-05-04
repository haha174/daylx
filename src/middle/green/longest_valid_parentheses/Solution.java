package middle.green.longest_valid_parentheses;

import java.util.Stack;

class Solution {
// 错误的
//    public int longestValidParentheses(String s) {
//        Stack<String> stack=new Stack<>();
//        int max=0;
//        int tmpMax=0;
//        for (int i=0;i<s.length();i++){
//            if (!stack.empty()&&s.charAt(i)==')' && "(".equals( stack.peek())){
//                stack.pop();
//                tmpMax+=2;
//            }else if (s.charAt(i)=='('){
//                stack.push(String.valueOf("("));
//            }else {
//                max=Math.max(max,tmpMax);
//                tmpMax=0;
//            }
//        }
//        return Math.max(max,tmpMax);
//    }



    int longestValidParentheses(String s) {
        int len = s.length();
        if(len<2)
            return 0;
        int max = 0;
        int []dp = new int[len];
        for(int i = len-2;i>=0;i--)
        {
            if(s.charAt(i) == '(')
            {
                int j = i+1+dp[i+1];
                if(j<len && s.charAt(j) == ')')
                {
                    dp[i] = dp[i+1] + 2;
                    if(j+1<len)
                        dp[i] += dp[j+1];
                }
                if(dp[i]>max)
                    max = dp[i];
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("()(()"));
       // System.out.println(new Solution().longestValidParentheses(")()())"));
    }
}