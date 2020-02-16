package ransom_note;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 *
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 */
class Solution {
//    public boolean canConstruct(String ransomNote, String magazine) {
//        if (ransomNote==null || ransomNote.length()==0){
//            return true;
//        }
//        if (magazine==null || magazine.length()==0){
//            return false;
//        }
//        char[] ransomNoteArray=ransomNote.toCharArray();
//        char[] magazineArray=magazine.toCharArray();
//        Arrays.sort(ransomNoteArray);
//        Arrays.sort(magazineArray);
//        int indexI=0;
//        int indexJ=0;
//        boolean flag=false;
//        while(indexI<ransomNoteArray.length &&indexJ< magazineArray.length){
//            if (ransomNoteArray[indexI]==magazineArray[indexJ]){
//                indexI++;
//                indexJ++;
//                flag=true;
//            }else{
//                indexJ++;
//                flag=false;
//            }
//        }
//        if (indexI==ransomNoteArray.length &&flag){
//            return true;
//        }else{
//            return false;
//        }
//    }
public boolean canConstruct(String ransomNote, String magazine) {
    final int[] indexes = new int[26];
    for (int i = 0; i < ransomNote.length(); i ++) {
        final char c = ransomNote.charAt(i);
        final int idx = magazine.indexOf(c, indexes[c - 'a']);
        if (idx < 0) {
            return false;
        }
        indexes[c - 'a'] = idx + 1;
    }
    return true;
}
    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("aa" ,"aab"));
    }
}