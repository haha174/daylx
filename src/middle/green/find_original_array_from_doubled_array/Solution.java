package middle.green.find_original_array_from_doubled_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        int[] result=new int[changed.length/2];
        int index=0;
        Map<Integer,Integer> map=new HashMap<>();
        Arrays.sort(changed);
        for (int i=0;i<changed.length;i++){
            map.put(changed[i],map.getOrDefault(changed[i],0)+1);
        }

        for (int i=0;i<changed.length && index<result.length;i++){
           if (map.getOrDefault(changed[i],0)>0 && map.getOrDefault(changed[i]*2,0)>0 ){
               map.put(changed[i],map.getOrDefault(changed[i],0)-1);
               map.put(changed[i]*2,map.getOrDefault(changed[i]*2,0)-1);
               if (map.getOrDefault(changed[i],0)<=0){
                   map.remove(changed[i]);
               }
               if (map.getOrDefault(changed[i]*2,0)<=0){
                   map.remove(changed[i]*2);
               }
               result[index++]=changed[i];
           }
        }
        if (map.size()>0){
            return new int[0];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] data= {6,3,0,1};
        System.out.println(new Solution().findOriginalArray(data));
    }
}