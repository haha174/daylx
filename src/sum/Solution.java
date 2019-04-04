package sum;

import java.util.*;



public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                result[0]=i;
                result[1]=map.get(temp);
                break;
            }else {
                map.put(nums[i],i);
            }
        }
        return result;
    }


        public int[] twoSum1(int[] nums, int target) {
            int[] a = new int[2];
            int[] b = new int[nums.length];
            int t = 0,m=nums.length-1;
            for(int k=0;k<nums.length;k++){
                if(nums[k]<=target){
                    b[t++] = k;
                }else{
                    b[m--] = k;
                }
            }
            if(t>0)t--;
            int i = t;
            if(target>0){ // less one lt target
                while(i>=0){
                    if(nums[b[i]]<0){
                        int n = getNextIndex(nums,nums[b[i]],target,t,b.length-1,b);
                        if(n!=-1 && n!=i){
                            a[0] = b[i];
                            a[1] = b[n];
                            return a;
                        }
                    }else{
                        int n = getNextIndex(nums,nums[b[i]],target,0,t,b);
                        if(n!=-1 && n!=i){
                            a[0] = b[n];
                            a[1] = b[i];
                            return a;
                        }
                    }
                    i--;
                }
            }
            if(target<0){ // less one gt target
                while(i<b.length){
                    if(nums[b[i]]>0){
                        int n = getNextIndex(nums,nums[b[i]],target,t,b.length-1,b);
                        if(n!=-1 && n!=i){
                            a[0] = b[i];
                            a[1] = b[n];
                            return a;
                        }
                    }else{
                        int n = getNextIndex(nums,nums[b[i]],target,0,b.length-1,b);
                        if(n!=-1 && n!=i){
                            a[0] = b[n];
                            a[1] = b[i];
                            return a;
                        }
                    }
                    i++;
                }
            }
            if(target==0){ // one gt 0 & one lt 0 & the value eq 0
                while(i>=0){
                    if(nums[b[i]]<0){
                        int n = getNextIndex(nums,nums[b[i]],target,t,b.length-1,b);
                        if(n!=-1 && n!=i){
                            a[0] = b[i];
                            a[1] = b[n];
                            return a;
                        }
                    }else{
                        int n = getNextIndex(nums,0,target,0,b.length-1,b);
                        if(n!=-1 && n!=i){
                            a[0] = b[n];
                            a[1] = b[i];
                            return a;
                        }
                    }
                    i--;
                }
            }
            return a;
        }
        public int getNextIndex(int[] a,int n,int target,int i,int j,int[] b){
            for(int h=i;h<=j;h++){
                if(n+a[b[h]]==target){
                    return h;
                }
            }
            return -1;
        }
}
