package before.length_of_last_word;

class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        if (s == null || s.length() == 0) {
            return length;
        }
        s=s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            } else {
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {

    }
}