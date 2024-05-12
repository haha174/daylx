package before.first_missing_positive;

public class Solution {
//        public int firstMissingPositive(int[] nums) {
//        if (nums != null && nums.length > 0) {
//            Set<Integer> setNums = new HashSet<>();
//            for (int i : nums) {
//                if(i>0){
//                    setNums.add(i);
//                }
//            }
//            for (int i = 1; i < Integer.MAX_VALUE; i++) {
//                if (!setNums.contains(i)) {
//                    return i;
//                }
//            }
//        }
//        return 1;
//    }
    public int firstMissingPositive(int[] nums) {
        int[] data=new int[nums.length+1];
        for (int i=0;i<nums.length;i++){
            if (nums[i]<=0 || nums[i]>nums.length){
                data[0]=1;
            }else {
                data[nums[i]]=1;
            }
        }
        int result=1;
        for (;result<data.length;result++){
            if (data[result]==0){
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{7,8,9,11,12};
        System.out.println(new Solution().firstMissingPositive(candidates));
    }
}