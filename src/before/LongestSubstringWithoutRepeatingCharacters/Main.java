package before.LongestSubstringWithoutRepeatingCharacters;

import java.util.Date;
import java.util.HashMap;


public class Main {
	public static void main(String[] args) {
		long start=new Date().getTime();
		System.out.println(lengthOfLongestSubstring("ab"));
		System.out.println(new Date().getTime()-start+"   毫秒");
	}
	public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
            	//如果map中保存了当前的char值  说明遇到了重复的字符串  则重新更替  
            	//但是 put 的操作  是在下面放进去的  所以这了的j保存的是  相同 char上一次出现的下标
            	//比如比配到了  下标为3的啊  此时   j  判断的的是  j和上一个a 的下标也就是 0的最大值
            	//  j = Math.max(j,map.get(s.charAt(i)));
            	//然而此时会有一个问题  假设  是adadc 在匹配到重复的a时  此时j的值为0  随后匹配到   b  j为1  4-1=3
            	//答案没有问题   因为遍历完成后  如果出现重复    j保存的是   上一个重复的字串的最后一个字符串的下标 
            	//所以重复的情况只需要相减即可
            	//而如果没有重复  则保存的是当前字串的起始下标   这样的处理需要加1
            	//统一一下将上述j的赋值改为下面就没有问题了
                j = Math.max(j,map.get(s.charAt(i))+1);
                
            }
            //加入hashmap
           //map  如果key相同 则会覆盖value则   map中保存的是较大的索引 
            map.put(s.charAt(i),i);
            //下标从0开始   所以结果加1
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
