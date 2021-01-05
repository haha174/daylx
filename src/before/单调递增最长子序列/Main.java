package before.单调递增最长子序列;
/**
 * 描述
    求一个字符串的最长递增子序列的长度
    如：dabdbf最长递增子序列就是abdf，长度为4

输入
    第一行一个整数0<n<20,表示有n个字符串要处理
    随后的n行，每行有一个字符串，该字符串的长度不会超过10000
输出
    输出字符串的最长递增子序列的长度
样例输入

    3
    aaa
    ababc
    abklmncdefg

样例输出

    1
    3
    7


 */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String sn=s.nextLine();
		int n=Integer.parseInt(sn);
		for(int i=0;i<n;i++) {
			String str=s.nextLine();
			char data[]=str.toCharArray();
			int[] num=new int[data.length];
			int max=0;
			for(int j=0;j<data.length;j++) {
				num[j]=1;
				for(int k=0;k<j;k++) {
					if(data[j]>data[k]&&num[k]+1>num[j]) {
						num[j]=num[k]+1;
					}
				}
			}
			for(int j=0;j<data.length;j++) {
				if(num[j]>max) {
					max=num[j];
				}
			}
			System.out.println(max);
			
			
		}
	}	
}
