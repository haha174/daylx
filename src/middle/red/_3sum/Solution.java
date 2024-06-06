package middle.red._3sum;
import java.util.*;
class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<>();
//        int n = nums.length;
//        //排序
//        Arrays.sort(nums);
//        for (int first=0;first<n-2;first++){
//            if (first>0 && nums[first]==nums[first-1]){
//                continue;
//            }
//            for (int second=first+1;second<n-1;second++){
//                if ( second>first+1 && nums[second]==nums[second-1]){
//                    continue;
//                }
//                for (int thd=second+1;thd<n;thd++){
//                    if (thd>second+1 && nums[thd]==nums[thd-1]){
//                        continue;
//                    }
//                    if (nums[first]+nums[second]+nums[thd]==0){
//                        List<Integer> t1=new ArrayList<>();
//                        t1.add(nums[first]);
//                        t1.add(nums[second]);
//                        t1.add(nums[thd]);
//                        lists.add(t1);
//                    }
//
//                }
//            }
//        }
//
//        return lists;
//    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        Map<Integer,Integer>  map=new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        //排序
        for (int first=0;first<n-2;first++){
            if (first>0 && nums[first]==nums[first-1]){
                continue;
            }
            for (int second=first+1;second<n-1;second++){
                int thd=-nums[first]-nums[second];
                if ((second>first+1 && nums[second]==nums[second-1] ) ||  nums[first]+nums[second]>0 || !map.containsKey(thd) ||  map.get(thd)<=second ){
                    continue;
                }
                List<Integer> t1=new ArrayList<>();
                t1.add(nums[first]);
                t1.add(nums[second]);
                t1.add(thd);
                lists.add(t1);
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        int[] data={1,2,-2,-1};
        System.out.println(new Solution().threeSum(data));
    }
}