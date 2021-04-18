package easy.green.prime_arrangements;

class Solution {
    public int numPrimeArrangements(int n) {
        int[] zhishu={
            2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,
            83,89,97
        };
        //计算质数个数
        int nzhishu=0;
        for(int c:zhishu){
            if(n>=c){
                nzhishu++;
            }
        }
        //计算非质数的个数
        int nfeizhishu=n-nzhishu;
        long ans=1;
        for(int i=nfeizhishu;i>1;i--){
            if(ans<1000000007/i){
                ans*=i;
            }
            else{
                ans=ans*i%1000000007;
            }
        }
        for(int i=nzhishu;i>1;i--){
            if(ans<1000000007/i){
                ans*=i;
            }
            else{
                ans=ans*i%1000000007;
            }
        }
        return (int)ans%1000000007;
    }
}
