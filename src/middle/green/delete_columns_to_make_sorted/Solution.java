package middle.green.delete_columns_to_make_sorted;

public class Solution {
    public int minDeletionSize(String[] strs) {
        int result=0;
        if (strs.length==0){
            return result;
        }
        for (int i=0;i<strs[0].length();i++){
            for (int j=1;j<strs.length;j++){
                if (strs[j-1].charAt(i)>strs[j].charAt(i)){
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs= {"cba","daf","ghi"};

        new Solution().minDeletionSize(strs);
    }
}