package middle.green.partition_labels;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result=new ArrayList<>();
        int[] c=new int[26];
        for (int i=0;i<s.length();i++){
            c[s.charAt(i)-'a']=i;
        }
        int cur=0;
        int lastIndex=-1;
        int max=0;
        while (cur<s.length()){
            max=Math.max(max,c[s.charAt(cur)-'a']);
            if (cur==max){
                result.add(cur-lastIndex);
                lastIndex=cur;
            }
            cur++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("eccbbbbdec"));
    }
}