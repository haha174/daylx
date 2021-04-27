package easy.green.check_array_formation_through_concatenation;

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int index=0;
        while (index<arr.length){
            int i=0;
            for (;i<pieces.length;i++){
                if (arr[index]==pieces[i][0]){
                    break;
                }
            }
            if (i==pieces.length){
                return false;
            }
            for (int j=0;j<pieces[i].length;j++){
                if (arr[index]==pieces[i][j]){
                    index++;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr={85};
        int[][] pieces={{85}};
        System.out.println(new Solution().canFormArray(arr,pieces));
    }
}