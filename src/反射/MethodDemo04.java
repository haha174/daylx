package 反射;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
//通过反射看泛型本质  6
public class MethodDemo04 {
	public static void main(String[] args) {
		List list1=new ArrayList<>();
		List<String> list2=new ArrayList<String>();
		list2.add("hello");
		//list2.add(22);报错
		/*
		 * 泛型
		 */
		Class c1=list1.getClass();
		Class c2=list2.getClass();
		System.out.println(c1==c2);
		/*发现打印的结果为true 说明java  编译之后的集合时去泛型话的
		*泛型的一个主要的功能是为了格式化数据类型防止输入错误  但是只在编译阶段有效
		*绕过编译就无效了
		*下面做一个测试
		*/
		try {
			Method m=c2.getMethod("add", Object.class);
			m.invoke(list2,20);
			System.out.println(list2);///[hello, 20]
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
