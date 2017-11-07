package 消除;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int sum=0;
		int[] a=new int[n];
		int[] b=new int[n];
		for(int i=0;i<n;i++) 
			a[i]=s.nextInt();
		for(int i=0;i<n;i++) 
			b[i]=s.nextInt();
		for(int i=0;i<n;i++) {
			//获取b  数组的最大值
			int j=checkMax(b);
			//  进行消除操作
			sum=sum+a[j]+checkLeft(b,j)+checkRight(b,j);
			//获得前面b  值 
			//获得后面 b  值
			a[j]=-1;  //代表被消除
			b[j]=-1;  //代表被消除
		}
		System.out.println(sum);
	}
	//每次查找  b  数据最大的
	public static int checkMax(int b[]) {
		int max=0;
		int j=0;
		for(int i=0;i<b.length;i++) 
			if(b[i]>max) {
				max=b[i];
				j=i;
			}
		return j;
	}
	public static int checkLeft(int b[],int j) {
		for(int i=j-1;i>=0;i--) 
			if(b[i]>=0) {
				return b[i]; 
			}
		return 0;
	}
	public static int checkRight(int b[],int j) {
		for(int i=j+1;i<b.length;i++) 
			if(b[i]>=0) {
				return b[i]; 
			}
		return 0;
	}
}
