package easy.green.three_consecutive_odds;

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i = 0;i <= arr.length - 3;++i){
            if((arr[i] & 1) != 0 && (arr[i+1] & 1) != 0 && (arr[i+2] & 1) != 0)
                return true;
        }
        return false;
    }
}

