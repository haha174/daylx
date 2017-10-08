package 反射;
//  1

public class ClassDemo2 {
	public static void main(String[] args) {
		//数据类型也有类类型   
		Class c1=int.class;
		Class c2=String.class;
		//关键字也有类类型  在类里面声明的都有
		Class c3=void.class;
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		//不带包名
		System.out.println(c2.getSimpleName());
	}
}
 
