package middle.red.letter_combinations_of_a_phone_number;

import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (combination.length() == digits.length()) {
            combinations.add(combination.toString());
        } else {
            String current=phoneMap.get(digits.charAt(index));
            for (char c:current.toCharArray()){
                combination.append(c);
                backtrack(combinations, phoneMap, digits, index+1, combination);
                combination.deleteCharAt(combination.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}