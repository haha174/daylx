package first_unique_character_in_a_string;

/**
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 *
 */
class Solution {
    public int firstUniqChar(String s) {
        if (s==null || s.length()==0){
            return -1;
        }
        char[] sArray=s.toCharArray();
        for (int i=0;i<sArray.length;i++){
            if (s.lastIndexOf(sArray[i])==i && s.indexOf(sArray[i])==i){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("leetcode"));
        System.out.println(new Solution().firstUniqChar("loveleetcode"));
    }
}