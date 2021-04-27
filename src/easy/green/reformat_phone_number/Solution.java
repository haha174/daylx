package easy.green.reformat_phone_number;

class Solution {
    public String reformatNumber(String number) {
        String ans = "";
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != ' ' && number.charAt(i) != '-') {
                ans += number.charAt(i);
                count++;
                if (count % 3 == 0) ans += "-";
            }
        }
        if (ans.length() < 3) return ans;
        int index = ans.lastIndexOf("-");
        if (index == ans.length() - 1) return ans.substring(0, index);
        char[] help = ans.toCharArray();
        if (help[help.length - 2] == '-') {
            char t = help[help.length - 3];
            help[help.length - 3] = help[help.length - 2];
            help[help.length - 2] = t;
        }
        return new String(help);
    }
}