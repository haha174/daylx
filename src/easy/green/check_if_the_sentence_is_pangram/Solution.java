package easy.green.check_if_the_sentence_is_pangram;

import java.util.HashSet;

class Solution {
    public boolean checkIfPangram(String sentence) {
            
        
        HashSet<Character> set =new HashSet<>();
        for(int i=0;i<sentence.length();i++){
            set.add(sentence.charAt(i));
        }
        return set.size()==26;
    }
}

