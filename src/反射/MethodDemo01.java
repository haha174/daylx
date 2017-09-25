package 反射;
//反射基本操作
import java.lang.reflect.Method;

public class MethodDemo01 {
	public static void main(String[] args) {
		A a=new A();
		Class c1=a.getClass();
		//获得参数
		try {
			Method print=c1.getDeclaredMethod("print", new Class[] {int.class,int.class});
			//Method print=c1.getDeclaredMethod("print", int.class,int.class);
			Object obj=print.invoke(a, new Object[] {10,20});
//			Object obj=print.invoke(a, 10,20);
			print=c1.getDeclaredMethod("print", new Class[] {String.class,String.class});
			 obj=print.invoke(a, new Object[] {"hello","world"});

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
class A{
	public void print(int a,int b) {
		System.out.println(a+b);
	}
	public void print(String a , String b) {
		System.out.println(a.toUpperCase()+b.toUpperCase());
	}
}
