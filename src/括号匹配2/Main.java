package 括号匹配2;

import java.util.Scanner;
public class Main {
	static int dp[][];//;
	static boolean  cmp(char n,char m)
	{
	    if((n == '('&&m == ')')||(n == '['&&m == ']'))
	        return true;
	    return false;
	}
	static int  min(int n,int m)
	{
	    if(n>m)
	        return m;
	    return n;
	}
	public static void main(String[] args) {
		int n,m,i,j,k;
	    Scanner s=new Scanner(System.in);
	    n=Integer.parseInt(s.nextLine().replaceAll(" ", ""));   
	    while(n>0)
	    {
	        String line=s.nextLine();
	        char str[]=line.toCharArray();
	        int length = str.length;
	        dp=new int[length][length];
	        for(i = 0; i < length; i++)
	            dp[i][i] = 1;
	        for(m = 1; m < length; m++)           //  ��  ���м�ֻ���һ������  ȥ����һ��
	        {
	            for(i = 0; i < length - m; i++)//�ж�֮ǰû�д�
	            {
	                j = i + m;              // j �� i  ��� m
	                dp[i][j] = 10000000;             // Ĭ��  i �� j ֮��
	                if(cmp(str[i],str[j]))                        //  ����   i  �� j �Ƿ�����  
	                    dp[i][j] = min(dp[i][j],dp[i+1][j-1]);       //   ���׵Ļ� �ʹ��ϴ� �� 
	                for(k = i; k < j; k++)
	                {
	                   dp[i][j] = min(dp[i][j],dp[i][k]+dp[k+1][j]);//���Ǻܶ�
	                }
	            }
	        }
	       System.out.println(dp[0][length-1]);
	        n--;
	    }
	}
}
