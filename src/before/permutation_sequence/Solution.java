package before.permutation_sequence;

import java.util.ArrayList;

/**
 * 这边取了一个factorial 数据 保存每取没位数字需要交换的次数， 通过k/factorial [n-1]  依次取得每位数
 * 因为除了 k/factorial [n-1] 所以下载迭代的时候需要对其求余
 */
class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k--;
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        while (n > 0) {
            int p = k / factorial[n - 1];
            res.append(nums.remove(p));
            k = k % factorial[n - 1];
            n = n - 1;
        }
        return res.toString();
}


//    public static void main(String[] args) {
//        System.out.println( new Solution().getPermutation(6,501));
//    }

    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        permutations(a,0,4);
    }
    public static void permutations(int[]a,int m,int n){
        if(m==n){

            for(int i=0;i<=n;i++){
                System.out.print(a[i]);
            }
            System.out.println();
        }else{
            for(int i=m;i<=n;i++){
                int temp=a[m];
                a[m]=a[i];
                a[i]=temp;
                permutations(a,m+1,n);
                temp=a[m];
                a[m]=a[i];
                a[i]=temp;
            }
        }
    }
}