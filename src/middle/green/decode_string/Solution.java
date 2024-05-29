package middle.green.decode_string;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    //    private static Pattern pattern=Pattern.compile("[0-9]+\\[[a-z]+");
    public String decodeString(String s) {
        Stack<Integer> multiStack = new Stack<>();
        Stack<StringBuilder> ansStack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int multi = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                multi=multi*10+c - '0';
            }else if ('['==c) {
                ansStack.add(ans);
                ans=new StringBuilder();
                multiStack.add(multi);
                multi=0;
            }else if (']'==c) {
                int tmpMulti=multiStack.pop();
                StringBuilder tmpAns = ansStack.pop();
                for (int i=0;i<tmpMulti;i++){
                    tmpAns.append(ans);
                }
                ans=tmpAns;
            }else {
                ans.append(c);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
    }
}