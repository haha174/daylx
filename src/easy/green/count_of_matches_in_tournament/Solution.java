package easy.green.count_of_matches_in_tournament;

class Solution {
    public int numberOfMatches(int n) {
        int tmp =0;
        while(n != 1){
            if(n%2==0){
                tmp =tmp +  n/2;
                n=n/2;
            }else{
                tmp = tmp + (n-1)/2;
                n=(n-1)/2 +1 ;
            }
        }
        return tmp;
    }
}
