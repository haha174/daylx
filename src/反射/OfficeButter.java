package 反射;
//   方法的反射

public class OfficeButter {
	public static void main(String[] args) {
		start("反射.Excel");
	}
	public static void  start(String str) {
		try {
			//动态加载
			Class c=Class.forName(str);
			//那么接下来做强制类型转换的时候  该转转那个类呢 此时我们设置一个借口  让word  和excel   实现它
			try {
				OfficeAble ab=(OfficeAble) c.newInstance();
				ab.start();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}
}

