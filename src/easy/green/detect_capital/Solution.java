package easy.green.detect_capital;

import java.util.Locale;

class Solution {
    public boolean detectCapitalUse(String word) {
            if (word==null || word.length()==0){
                return false;
            }

            if (word.equals(word.toUpperCase())){
                return true;
            }
            if (word.equals(word.toLowerCase())){
                return true;
            }
            if (word.equals(word.toUpperCase().substring(0,1)+word.toLowerCase().substring(1,word.length())))
            {
                return true;
            }
            return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().detectCapitalUse("FlaG"));
    }
}