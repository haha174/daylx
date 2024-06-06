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
           if (Character.isDigit(c)){
               multi=multi*10+(c-'0');
           }else if ('['==c){
               multiStack.add(multi);
               ansStack.add(ans);
               multi=0;
               ans=new StringBuilder();
           }else if (']'==c){
               StringBuilder tmp=ansStack.pop();
               int multiTmp=multiStack.pop();
               for (int i=0;i<multiTmp;i++){
                   tmp.append(ans);
               }
               ans=tmp;
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