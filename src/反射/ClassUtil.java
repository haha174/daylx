package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
//3  获取方法信息   4  获取成员构造
public class ClassUtil {
	public static void main(String[] args) {
		String str="cxhc";
		printClassConsur(str);
	}
	public static void printClassMessage(Object obj) {
		//首先获取类类型 
		Class c1=obj.getClass();  //c  就是该类的类类型
		//  public final native Class<?> getClass()
		//获取类的名称
		System.out.println(c1.getName());
		/*获得全部对象   里面包括所有的public  的方法  包括父类继承的
		 *c1.getDeclaredMethods();  取得所有自己声明的方法不论访问权限
	     */
		Method[] me=c1.getMethods(); 
		for(int i=0;i<me.length;i++) {
			System.out.println(me[i].getReturnType());//获取方法的返回值类型  类类型   如  String  返回的是String.class
			//要获取返回值的名称
			System.out.println(me[i].getReturnType().getName());
			System.out.println(me[i].getName()+"(");//获取方法的名称
			//获取参数类型  得到的是类类型  例如  int  的到的是 int.class
			Class[] prarm=me[i].getParameterTypes();
			for (Class class1 : prarm) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	
	
	}
	public static void printClassField(Object obj) {
		//首先获取类类型 
				Class c1=obj.getClass();  //c  就是该类的类类型
		
		/*
		 * 成员变量也是对象
		 * java.lang.reflect.Field
		 * Field 类封装关于成员变量的操作
		 * getFields()   获取所有public   成员变量的信息  
		 * getDeclareFields 取得所有自定义的成员变量
		 *
		 */
		Field[] fs=c1.getDeclaredFields();  //取得所有的类类型
		for (Field field : fs) {
			Class fieldType=field.getType();
			String typeName=fieldType.getName();
			String fieldName=field.getName();
			System.out.println(typeName);
			System.out.println(fieldName);
		}
	}
	//获取构造函数信息
	
	public static void printClassConsur(Object obj) {

		/*
		 * 成员变量也是对象
		 * java.lang.reflect.Constructor
		 * Field 类封装关于成员变量的操作
		 * getConstructors()   获取所有public   成员变量的信息  
		 * getDeclareConstructors 取得所有自定义的成员变量
		 *
		 */
	       Class c1=obj.getClass();
	       Constructor[] cu=c1.getConstructors();
	       for (Constructor constructor : cu) {
	    	   //constructor
	    	   System.out.print(constructor.getName());
	    	   //得到的是参数列表的类类型
	    	   Class[] types=constructor.getParameterTypes();
	    	   System.out.print("(");
	    	   for (Class class1 : types) {
				System.out.print(class1.getName()+",");
			}
	    	   System.out.println(")");

	       }
	       
	}
}
