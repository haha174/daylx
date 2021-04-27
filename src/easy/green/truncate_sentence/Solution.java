package easy.green.truncate_sentence;

class Solution {
    public String truncateSentence(String s, int k) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ')
                sum++;
            if (sum == k)
                return s.substring(0, i);
        }
        return s;
    }
}
