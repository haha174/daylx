package easy.green.most_visited_sector_in_a_circular_track;

import java.util.*;
class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> result=new ArrayList<>();
        int[] visit=new int[n+1];
        visit[rounds[0]]++;
        for (int i=1;i<rounds.length;i++){
            int start=rounds[i-1];
            int end=rounds[i];
            if (end>start){
                while (start<end){
                    start++;
                    visit[start]++;
                }
            }else {
                int temp=0;

                while (temp<end){
                    temp++;
                    visit[temp]++;
                }
                temp=start;
                while (temp<n){
                    temp++;
                    visit[temp]++;
                }
            }
        }
        int max=-1;
        for (int i=1;i<visit.length;i++){
            if (visit[i]>max){
                max=visit[i];
            }
        }
        for (int i=1;i<visit.length;i++){
            if (visit[i]==max){
               result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] rounds = {1,3,1,2};
        System.out.println(new Solution().mostVisited(n,rounds));
    }
}