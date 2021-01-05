package before.reverse_vowels_of_a_string;

/**
 *
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 *
 *
 */
class Solution {

    public String reverseVowels(String s) {
        if (s==null || s.length()==0){
            return s;
        }
        boolean[] vowels = new boolean[256];
        vowels['a'] = true;
        vowels['o'] = true;
        vowels['e'] = true;
        vowels['i'] = true;
        vowels['u'] = true;
        vowels['A'] = true;
        vowels['O'] = true;
        vowels['E'] = true;
        vowels['I'] = true;
        vowels['U'] = true;

        char[] input = s.toCharArray();

        char[] sArray=s.toCharArray();
        int letf=0;int right=s.length()-1;
        while (letf<right){
            while (letf<right &&!vowels[sArray[letf]]){
                letf++;
            }
            while (letf<right &&!vowels[sArray[right]]){
                right--;
            }
            if (right>letf){
                char temp=sArray[letf];
                sArray[letf]=sArray[right];
                sArray[right]=temp;
                letf++;
                right--;
            }
        }
        return new String(sArray);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("leetcode"));
    }
}