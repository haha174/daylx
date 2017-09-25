package 反射;
//Class 类的使用   1
public class ClassDemo01 {
	public static void main(String[] args) {
		//java  中万事万物都是对象
		//Food  这个类也是一个实例对象  是Class  类的实例对象
		Food food=new Food();

		//那Class  类的实例对象怎么表示呢源码
		//任何一个类  都是class  的实例对象  这个对象有三种表示的方式
		//第一种  类.class
		Class c1=Food.class;  //实例也告诉我们们任何一个类都有一个隐含的静态成员变量
		
		//第二种表达方式    已知该类的对象通过getClass()方式
		Class c2=food.getClass();
		/*
		*c1  c2  表示的是  Food类的类类型  原文翻译是(class type)  
		*指的是  Food 本生就是一个对象   是  Class类创建  的对象   
		*但是Food本身也有实例对象  将  c1  和c2  成为 Food 的  类类型
		*感觉描述的优点绕自己都看不懂了     。。。
		*总结一下   万事万物皆对象    类也是对象  是Class类的对象  这个对象称为该类的类类型	
		*/
		//那么c1  和c2  相等么c1  是等于  c2  的一个类只可能是Class类的一个实例对象
		System.out.println(c1==c2);
		//第三种  表达方式forName
		Class c3=null;
		 try {
			c3=Class.forName("反射.Food");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //也是相等的和上面描述的一样
		 System.out.println(c2==c3);
		 //可以通过该类的类类型创建该对象的实例
		 try {
			Food food1=(Food) c1.newInstance();//前提要求有无参构造
			food1.print();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
 class Food{
	 public void print() {		 
		 System.out.println("我叫Food");
	 }
 } 
