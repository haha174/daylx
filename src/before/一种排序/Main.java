package before.一种排序;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner scanner =new Scanner(System.in);
        int sum=scanner.nextInt();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<sum;i++){
            List <Reis> lr=new ArrayList<Reis>();
            int num=scanner.nextInt();
            for(int j=0;j<num;j++){
                int no=scanner.nextInt();
                int a=scanner.nextInt();
                int b=scanner.nextInt();
                Reis r=new Reis(no, a>b?a:b,a<b?a:b);
                if(!checkExit(lr, r)){
                    lr.add(r);
                }
            }
            Collections.sort(lr, new Comparator<Reis>(){  
                @Override  
                public int compare(Reis r1, Reis r2) {  
                    if (r1.no != r2.no) {
                        return r1.no > r2.no ? 1 : -1;
                    } else {
                        if (r1.a != r2.a) {
                            return r1.a > r2.a ? 1: -1;
                        } else if(r1.b != r2.b){
                            return r1.b > r2.b ? 1 : -1;
                        } else {
                            return 0;
                        }
                    }
                }  
            });  
            for(int j=0 ; j<lr.size(); j++) {
                result.append(lr.get(j).toString()).append("\n");
            }
        }
        System.out.println(result.toString());
    }
    public static boolean checkExit(List<Reis> list,Reis r){
        for (int i=0; i<list.size(); i++) {
            Reis r1 = list.get(i);
            if (r1.no == r.no && r1.a==r.a && r1.b == r.b) {
                return true;
            }
        }
        return false;
    }
} 
class Reis{
    int no;
    int a;
    int b;
    public  Reis(int no,int a,int b){
        this.a=a;
        this.b=b;
        this.no=no;
    }
    public String toString() {
        return no + " " + a + " " + b;
    }
}