package easy.green.build_an_array_with_stack_operations;
import java.util.*;
class Solution {
    public List<String> buildArray(int[] target, int n) {
        int index=0;
        List<String> result=new ArrayList<>();
        for (int i=1;i<=n && index<target.length;i++){
            if (target[index]==i){
                result.add("Push");
                index++;
            } else if (target[index]>i) {
                result.add("Push");
                result.add("Pop");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data={1,2};
        System.out.println(new Solution().buildArray(data,4));
    }
}