package 喷水装置2;


/*
 * 喷水装置（二）
时间限制：3000 ms  |  内存限制：65535 KB
难度：4

描述
    有一块草坪，横向长w,纵向长为h,在它的橫向中心线上不同位置处装有n(n<=10000)个点状的喷水装置，每个喷水装置i喷水的效果是让以它为中心半径为Ri的圆都被润湿。请在给出的喷水装置中选择尽量少的喷水装置，把整个草坪全部润湿。

输入
    第一行输入一个正整数N表示共有n次测试数据。
    每一组测试数据的第一行有三个整数n,w,h，n表示共有n个喷水装置，w表示草坪的横向长度，h表示草坪的纵向长度。
    随后的n行，都有两个整数xi和ri,xi表示第i个喷水装置的的横坐标（最左边为0），ri表示该喷水装置能覆盖的圆的半径。
输出
    每组测试数据输出一个正整数，表示共需要多少个喷水装置，每个输出单独占一行。
    如果不存在一种能够把整个草坪湿润的方案，请输出0。
样例输入
2
 2 8 6
    1 1
    4 5
    2 10 6
    4 5
    6 5

样例输出

    1
    2
 */
/*
 * 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class PSZZ2 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		List <Data> list;
		for(int i=0;i<n;i++) {
			int num=0,w=0,h=0;
			list =new ArrayList<Data>();
			num=s.nextInt();
			w=s.nextInt();
			Data data=new Data();
			h=s.nextInt();
			for(int j=0;j<num;j++) {
				data=new Data();
				data.left=s.nextInt();
				double temp=s.nextInt();
				temp=Math.sqrt(temp*temp-h/2*h/2);
		            if(temp > h/2.0)  {
		            	data.right=data.left+temp;
		            	data.left=data.left-temp;
		            	list.add(data);
		            }
			}
			Collections.sort(list, new Comparator<Data>() {  
				  
                public int compare( Data o1, Data o2) {  
  
                    return o1.left>o2.left?1:-1;  
                }  
            });  
			 double right=0.0;  
	            int count=0;  
	            while(right<w)  
	            {  
	                double m=0.0;  
	                for(int j=0;j<list.size()&&list.get(j).left<=right;j++)  
	                {  
	                    if(list.get(j).right-right>m) m=list.get(j).right-right;  
	                }  
	                if(m!=0)  
	                {  
	                    count++;  
	                    right+=m;  
	                }  
	                else break;  
	            }  
	            if(right<w)System.out.println(0);
	            else System.out.println(count);;  
		}
	} 
	static class Data{
		public double left;
		public double right;
	}
}
