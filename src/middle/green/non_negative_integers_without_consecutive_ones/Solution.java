package middle.green.non_negative_integers_without_consecutive_ones;

class Solution {
    boolean[] flag;
    public int findIntegers(int n) {
        flag=new boolean[n+1];
        int result=0;
        for (int i=0;i<=n;i++){
            if (check( i,false)){
                result++;
                flag[i]=true;
            }
        }
        return result;
    }

    public boolean check(int k,boolean flag){
        if (k%2==0){
            if (k==0) return true;
            return check(k/2,false);
        }else {
            if (flag==true){
                return false;
            }
            if (this.flag[k]){
                return true;
            }
            return check(k/2,true);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findIntegers(1000000000));
    }
}