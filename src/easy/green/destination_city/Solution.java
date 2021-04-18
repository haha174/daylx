package easy.green.destination_city;
import java.util.*;
class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String,Integer> map = new HashMap<>();
        for(List<String> list : paths){
            map.put(list.get(0),1);
        }
        for(List<String> list : paths){
            if(map.get(list.get(1))==null)return list.get(1);
        }
        return null;
    }
}
