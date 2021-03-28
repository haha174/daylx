package easy.green.occurrences_after_bigram;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] textArray=text.split(" ");
        List<String> result=new ArrayList<>();
        for (int i=2;i<textArray.length;i++){
            if (textArray[i-2].equals(first) && textArray[i-1].equals(second)){
                result.add(textArray[i]);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}