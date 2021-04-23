package easy.green.kth_missing_positive_number;

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int max=arr[arr.length-1];
        int index=0;
        int tK=k;
        for (int i=1;i<=(max+tK);i++){
            if (index>=arr.length || arr[index]>i){
                k--;
                if (k==0){
                    return i;
                }
            }else if(arr[index]<=i){
                index++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data={1,2,3,4};
        System.out.println(new Solution().findKthPositive(data,2));
    }
}