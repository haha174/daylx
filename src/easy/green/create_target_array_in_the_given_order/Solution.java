package easy.green.create_target_array_in_the_given_order;

import java.util.LinkedList;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            linkedList.add(index[i],nums[i]);
        }
        return linkedList.stream().mapToInt(Integer::intValue).toArray();
    }
}