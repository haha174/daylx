package easy.green.string_matching_in_an_array;

import java.util.*;
class Solution {
    public List<String> stringMatching(String[] words) {
        if(words == null || words.length < 1) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();

        String allS = String.join(",", words);
        for(String s : words) {
            if(allS.indexOf(s) != allS.lastIndexOf(s)) {
                res.add(s);
            }
        }

        return res;
    }
}