package middle.red._3sum;
import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        //排序
        Arrays.sort(nums);
        for (int first=0;first<nums.length-2;first++){
            if (first>0 && nums[first]==nums[first-1]){
                continue;
            }

            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];

            for (int second=first+1;second<nums.length-1;second++){

                if ( second>first+1 && nums[second]==nums[second-1]){
                    continue;
                }

                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[first]+nums[second]+nums[third]==0){
                    List<Integer> t1=new ArrayList<>();
                    t1.add(nums[first]);
                    t1.add(nums[second]);
                    t1.add(nums[third]);
                    lists.add(t1);
                }

            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] data={0,0,0,0};
        System.out.println(new Solution().threeSum(data));
    }
}