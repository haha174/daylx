package easy.green.count_items_matching_a_rule;
import java.util.*;
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int i = 0,res=0;
        if (ruleKey.equals("color"))  i = 1;  
        if (ruleKey.equals("name"))  i = 2;
        for (int j = 0; j < items.size(); j++) {
            if (items.get(j).get(i).equals(ruleValue))  res++;    
        }
        return res;
    }
}

