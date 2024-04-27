package middle.green.study_plan_v2;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String,List<String>> result=new HashMap<>();
//          for (String s:strs){
//             String sort=getString(s);
//             if (!result.containsKey(sort)){
//                 result.put(sort,new ArrayList<>());
//             }
//              result.get(sort).add(s);
//          }
//          return new ArrayList<>(result.values());
//    }
//
//    public String getString(String str){
//        char[] index=new char[26];
//        for (char c:str.toCharArray()){
//            index[c-97]++;
//        }
//        StringBuilder stringBuilder=new StringBuilder();
//        for (char c:index){
//            stringBuilder.append(c);
//        }
//        return stringBuilder.toString();
//
//    }
//
//    public static void main(String[] args) {
//        String[] data={"eat","tea","tan","ate","nat","bat"};
//        System.out.println(new Solution().groupAnagrams(data));
//    }

    public List<List<String>> groupAnagrams(String[] strs) {
       return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(x->Arrays.toString(x.codePoints().sorted().toArray()))).values());
    }

    public static void main(String[] args) {
        String[] data={"eat","tea","tan","ate","nat","bat"};
        System.out.println(new Solution().groupAnagrams(data));
    }
}