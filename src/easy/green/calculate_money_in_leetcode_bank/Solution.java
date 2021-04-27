package easy.green.calculate_money_in_leetcode_bank;

class Solution {
    public int totalMoney(int n) {
        int result=0,count=0;
        while(n/7!=0){
            count++;
            result+=7*count+21;
            n=n-7;
        }
        if(n%7!=0){
            count++;
            for(int i=0;i<n%7;i++){
                result+=count;
                count++;
            }
        }
        return result;
    }
}