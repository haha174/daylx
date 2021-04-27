package easy.green.ccw6C7;

class Solution {
    int factorial[];//阶乘表
    public int paintingPlan(int n, int k) {
        if(k==n*n || k==0) return 1;//特殊判断，不涂或者全涂
        factorial=new int[n+1];
        factorial[0]=1;
        for(int i = 1;i<=n;i++) factorial[i] = factorial[i-1] * i;
        int count=0;
        for (int i = 0; i*n <= k; i++) {
            //设i行,j列，则棋子数目k=i*n+j*(n-i)
            if((k-i*n)%(n-i) ==0) { //保证j整数
                int j = (k-i*n)/(n-i);
                count+=combination(n,i)*combination(n,j);
            }
        }
        return count;
    }

    private int combination(int n ,int r){
        return factorial[n]/(factorial[r]*factorial[n-r]);
    }
}
