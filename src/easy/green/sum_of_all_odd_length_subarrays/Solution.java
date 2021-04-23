package easy.green.sum_of_all_odd_length_subarrays;

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length, res = 0;
        for(int i = 0; i < len; i ++){
            int LeftOdd = (i+1)/2, LeftEven = i/2+1;
            int RightOdd = (len-i)/2, RightEven = (len-1-i)/2+1;
            res += arr[i]*(LeftOdd*RightOdd + LeftEven*RightEven);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] data={1,4,2,5,3};
        System.out.println(new Solution().sumOddLengthSubarrays(data));
    }
}