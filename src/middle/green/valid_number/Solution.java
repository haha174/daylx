package middle.green.valid_number;

import java.util.regex.Pattern;

class Solution {
    public boolean isNumber(String s) {
        String number = "([+-]?(\\d+(\\.\\d*)?|(\\.\\d+)))";
        Pattern base = Pattern.compile(number + "([eE][+-]?\\d+)?");
        return base.matcher(s).matches();
    }
    public static void main(String[] args) {
        String [] trueArray={"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        String[] falseArray={"-.9"};
        for (String arr:falseArray){
            System.out.println(new Solution().isNumber(arr));
        }
    }
}