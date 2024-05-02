package middle.green.decode_string;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

//    private static Pattern pattern=Pattern.compile("[0-9]+\\[[a-z]+");
public String decodeString(String s) {
    StringBuffer ans=new StringBuffer();
    Stack<Integer> multiStack=new Stack<>();
    Stack<StringBuffer> ansStack=new Stack<>();
    int multi=0;
    for(char c:s.toCharArray()){
        if(Character.isDigit(c)) {
            multi = multi * 10 + c - '0';
        }else if(c=='['){
            ansStack.add(ans);
            multiStack.add(multi);
            ans=new StringBuffer();
            multi=0;
        }else if(Character.isAlphabetic(c)){
            ans.append(c);
        }else{
            StringBuffer ansTmp=ansStack.pop();
            int tmp=multiStack.pop();
            for(int i=0;i<tmp;i++){
                ansTmp.append(ans);
            };
            ans=ansTmp;
        }
    }
    return ans.toString();
}

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a2[c5[e]]]"));
    }
}