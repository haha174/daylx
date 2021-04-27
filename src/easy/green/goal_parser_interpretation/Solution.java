package easy.green.goal_parser_interpretation;

class Solution {
    public String interpret(String command) {
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<command.length();i++){
            if(command.charAt(i) == '(' && command.charAt(i+1) == ')'){
                stringBuffer.append("o");
                i++;
            }
            if(command.charAt(i) == '(' && command.charAt(i+1) != ')'){
                stringBuffer.append("al");
                i=i+3;
            }
            if(command.charAt(i) == 'G'){
                stringBuffer.append("G");
            }
        }
        return new String(stringBuffer);
    }
}
