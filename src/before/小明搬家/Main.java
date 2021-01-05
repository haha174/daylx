package before.小明搬家;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int[] data=new int[n];
		for(int i=0;i<n;i++) {
			data[i]=scanner.nextInt();
		}
		Arrays.sort(data);
		int sum=0;
		//创建一个二维数组存储结果
		int date=n%k==0?n/k:n/k+1;
		int[][] temp=new int[date][k]; 
		int j=0;
		int i=0;
		while(date>0) {
			date--;
			for(i=0;i<n&&j<k;i++) {
				if(data[i]>0) {
					temp[date][j]=data[i];
					sum=sum+data[i];
					data[i]=0;
					j++;
				}
			}
			//代表一圈加成功了
			if(j>=k) {
				data[i-1]=sum;
			}
			Arrays.sort(data);
			sum=0;
			j=0;
		}
		date=n%k==0?n/k:n/k+1;
		for(i=0;i<date;i++) {
			for(j=0;j<k;j++) {
				sum=sum+temp[i][j];
			}
		}
		System.out.println(sum);
	}
}
