package middle.red.letter_combinations_of_a_phone_number;
import java.util.*;
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> results = new LinkedList<String>();
        if (digits.equals(""))
            return results;
        results.add("");
        String[] arr = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for (char c : digits.toCharArray()){
            int digit = Character.getNumericValue(c);
            List<String> newCharList = new LinkedList<String>();
            for (String str : results){
                for (char ch : arr[digit].toCharArray()){
                    newCharList.add(str + ch);
                }
            }
            results = newCharList;
        }
        return results;
    }
}