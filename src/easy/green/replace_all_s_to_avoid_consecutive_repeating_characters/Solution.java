package easy.green.replace_all_s_to_avoid_consecutive_repeating_characters;

class Solution {
    public String modifyString(String s) {
        int len = s.length();
        int index = s.indexOf('?');
        while(index!=-1){
            char tmp = 'a';
            s = s.substring(0,index)+tmp+s.substring(index+1);
            //前后判断
            while (index<len-1&&s.charAt(index)==s.charAt(index+1)||index>0&&s.charAt(index)==s.charAt(index-1)){
                s = s.substring(0,index)+(tmp++)+s.substring(index+1);
            }
            index=s.indexOf('?');
        }
        return s;
    }
}
