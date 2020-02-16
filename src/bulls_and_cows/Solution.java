package bulls_and_cows;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 * <p>
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 * <p>
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.
 * <p>
 * Please note that both secret number and friend's guess may contain duplicate digits.
 * <p>
 * Example 1:
 * <p>
 * Input: secret = "1807", guess = "7810"
 * <p>
 * Output: "1A3B"
 * <p>
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 * <p>
 * Input: secret = "1123", guess = "0111"
 * <p>
 * Output: "1A1B"
 * <p>
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 */
class Solution {
    public String getHint(String secret, String guess) {
        char[] schar = secret.toCharArray();
        char[] gchar = guess.toCharArray();
        int[] sfreq = new int[128];
        int[] gfreq = new int[128];
        int n = schar.length;
        int acount = 0, bcount = 0;
        for (int i = 0; i < n; i++) {
            if (schar[i] == gchar[i]) {
                acount++;
            }
            else {
                sfreq[schar[i]]++;
                gfreq[gchar[i]]++;
            }
        }
        for (int i = 0; i < 128; i++) {
            bcount += Math.min(sfreq[i], gfreq[i]);
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(acount).append('A').append(bcount).append('B').toString();
    }
    public static void main(String[] args) {
        //  System.out.println('1'-1);
        //System.out.println(new Solution().getHint("1807","7810"));
        System.out.println(new Solution().getHint("1107", "1110"));

    }
}