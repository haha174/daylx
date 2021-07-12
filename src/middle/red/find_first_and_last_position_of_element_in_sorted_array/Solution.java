package middle.red.find_first_and_last_position_of_element_in_sorted_array;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length>0){
            searchRange(nums, result, target, 0, nums.length - 1);
        }
        return result;
    }


    public void searchRange(int[] nums, int[] result, int target, int start, int end) {
        int mid = (end + start) / 2;
        if (nums[mid] > target && end>=start) {
            searchRange(nums, result, target, start, mid-1);
        } else if (nums[mid] < target  && end>=start ) {
            searchRange(nums, result, target, mid+1, end);
        } else if (nums[mid] == target ){
            int leftIndex=end;
            int rightIndex=start;
            for (int i=mid;i>=start;i--){
                if (nums[i]==target){
                    leftIndex=i;
                }else {
                    break;
                }
            }
            for (int i=mid;i<=end;i++){
                if (nums[i]==target){
                    rightIndex=i;
                }else {
                    break;
                }
            }
            result[0] = leftIndex;
            result[1] = rightIndex;
        }
    }

    public static void main(String[] args) {
        int[] data={5,7,7,8,8,10};
        System.out.println(new Solution().searchRange(data,6));
    }
}