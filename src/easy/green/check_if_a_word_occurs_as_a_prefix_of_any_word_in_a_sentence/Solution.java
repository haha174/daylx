package easy.green.check_if_a_word_occurs_as_a_prefix_of_any_word_in_a_sentence;

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        //先按" "分开
        String[] arr = sentence.split(" ");
        int i;
        //如果包含且下标为0,就直接break
        for( i = 0;i < arr.length;i++){
            if(arr[i].indexOf(searchWord) == 0){
                break;
            }
        }
        //判断是因为什么退出的,然后返回结果
        if(i >= arr.length){
            return -1;
        }else{
            return i+1;
        }
    }
}
