package before.会场安排问题;



/*
 * 描述
    学校的小礼堂每天都会有许多活动，有时间这些活动的计划时间会发生冲突，需要选择出一些活动进行举办。小刘的工作就是安排学校小礼堂的活动，每个时间最多安排一个活动。现在小刘有一些活动计划的时间表，他想尽可能的安排更多的活动，请问他该如何安排。

输入
    第一行是一个整型数m(m<100)表示共有m组测试数据。
    每组测试数据的第一行是一个整数n(1<n<10000)表示该测试数据共有n个活动。
    随后的n行，每行有两个正整数Bi,Ei(0<=Bi,Ei<10000),分别表示第i个活动的起始与结束时间（Bi<=Ei)
输出
    对于每一组输入，输出最多能够安排的活动数量。
    每组的输出占一行
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=0;i<n;i++) {
			int m=s.nextInt();
			int count=0;
			List<Data> list=new ArrayList<Data>();
			Data data;//=new Data();
			int right=0;
			for(int j=0;j<m;j++) {
				data=new Data();
				data.left=s.nextInt();
				data.right=s.nextInt();
				list.add(data);
			}
			Collections.sort(list, new Comparator<Data>() {  
				  @Override
                public int compare( Data o1, Data o2) {  
  
                    return o1.right>o2.right?1:-1;  
                }  
            });  
			if(list.size()>0) {
				count=1;
				right=list.get(0).right;
			}
			for(int j=1;j<list.size();j++) {
				if(list.get(j).left>right) {
					right=list.get(j).right;
					count++;
				}
			}
			System.out.println(count);
		}
	}
	static class Data{
		int left;
		int right;
	}
}
