package easy.green.find_words_that_can_be_formed_by_characters;

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charsIndex=new int[26];
        int result=0;
        char[] charsArray=chars.toCharArray();
        for (int i=0;i<charsArray.length;i++){
            charsIndex[charsArray[i]-'a']++;
        }
        for (int i=0;i<words.length;i++){
            char[] wordArray=words[i].toCharArray();
            int[] wordIndex=new int[26];
            for (int j=0;j<wordArray.length;j++){
                wordIndex[wordArray[j]-'a']++;
            }
            boolean flag=true;
            for (int j=0;j<wordIndex.length;j++){
               if ( wordIndex[j]>charsIndex[j]){
                   flag=false;
                   break;
               }
            }
            if (flag){
                result+=wordArray.length;
            }
        }
        return result;
    }

    public static void main(String[] args) {

       String[] words= {"hello","world","leetcode"};
       String chars = "welldonehoneyr";
        System.out.println(new Solution().countCharacters(words,chars));
    }
}