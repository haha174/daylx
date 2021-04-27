package easy.green.count_the_number_of_consistent_strings;

import java.util.*;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int tmp=0;
        int res=0;
        for(int i=0;i<words.length;i++){
            words[i] =  sub1(words[i]);
            for(int j=0;j<words[i].length();j++){
                if(allowed.contains(words[i].charAt(j)+"")) res++;              
            }
            if(res==words[i].length()) tmp++;  res=0; 
            res=0;
        }
        return tmp;
        
    }
    //去重
	public static String sub1(String str){
		List list = new ArrayList();
		StringBuffer sb = new StringBuffer(str);
		int j=0;
		for(int i=0; i<str.length(); i++){
			if(list.contains(str.charAt(i))){
				sb.deleteCharAt(i-j);     //String 是没有delete方法的
				j++; //因为删除了sb中的字符，有一个偏移
			}else{
				list.add(str.charAt(i));
			}
		}
		return sb.toString();
	}

}
