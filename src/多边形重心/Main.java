package 多边形重心;
import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        int n=0;
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        for(int i=0;i<n;i++){
            int n1=s.nextInt();
            double data[][]=new double[n1][2];
            double sc=0;
            double sx=0;
            double sy=0;
            for(int j=0;j<n1;j++){
                data[j][0]=s.nextDouble();
                data[j][1]=s.nextDouble();
            }            
             for (int j = 1; j <= n1; j++) {  
                    double temp=(data[j % n1][0]*data[j-1][1]-data[j % n1][1]*data[j -1][0])/2.0;  
                    sc=sc+temp;
                    sx=sx+temp*(data[j % n1][0]+data[j-1][0])/3;
                    sy=sy+temp*(data[j % n1][1]+data[j-1][1])/3;
                }  
             //result取绝对值  
             if (sc - 0 < 0.0000001) {  
                    System.out.println("0.000 0.000");  
                    continue;  
                }  
                    System.out.print(String.format("%.3f %.3f\n",sc,(sx + sy)/sc));  
        }
    }
}