package easy.green.count_good_triplets;

class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int i=0,j,k,ans=0,index=-1;
        int[] list=new int[arr.length];/*存放i固定时满足|arr[i] - arr[k]|<=c的k*/
        while(i<arr.length-2){
            j=i+1;
            while(j<arr.length-1&&Math.abs(arr[i]-arr[j])>a)j++;/*不满足|arr[i] - arr[j]|<=a时对j减枝*/
            while(j<arr.length-1){
                if(index<0){/*判断list是否为空*/
                    k=j+1;
                    while(k<arr.length){
                        if(Math.abs(arr[i]-arr[k])<=c){/*将满足条件的k存放在list中*/
                            list[++index]=k;
                            if(Math.abs(arr[j]-arr[k])<=b)ans++;
                        }
                        k++;
                    }
                }else{/*直接从list中遍历，一定满足|arr[i] - arr[k]|<=c*/
                    int t=0;
                    while(t<=index&&list[t]<=j)t++;
                    while(t<=index){
                        if(Math.abs(arr[j]-arr[list[t]])<=b)ans++;
                        t++;
                    }
                }
                j++;
                while(j < arr.length-1 && Math.abs(arr[i] - arr[j]) > a)j++;/*不满足|arr[i] - arr[j]|<=a时对j减枝*/
            }
            index=-1;/*list置为空*/
            i++;
        }
        return ans;
    }

}