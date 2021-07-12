package middle.red.sliding_puzzle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.*;

public class solution {
    int[][] num = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                sb.append(board[i][j]);
            }
        }//拼成字符串
        String init = sb.toString();//初始字符串
        if(init.equals("123450")) return 0;//初始就是目标值，则不用动
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(init);
        Set<String> visit = new HashSet<>();
        visit.add(init);
        while (!queue.isEmpty()){
            step++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                String p = queue.poll();
                for(String next:next(p)){
                    if(!visit.contains(next)){
                        if(next.equals("123450")){
                            return step;
                        }
                        queue.offer(next);
                        visit.add(next);
                    }
                }
            }
        }
        return -1;
    }

    public List<String> next(String p){
        List<String> res = new LinkedList<>();//可到达的节点集合
        char[] array = p.toCharArray();
        int place0 = p.indexOf('0');
        for(int x:num[place0]){
            char i = array[place0];//0的位置
            array[place0] = array[x];//这三步是交换位置
            array[x] = i;
            res.add(new String(array));
            char j = array[place0];//这三步是因为此时array已经改变，需要还原，再次交换回来
            array[place0] = array[x];
            array[x] = j;
        }
        return res;
    }
}