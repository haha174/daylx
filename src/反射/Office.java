package 反射;

public class Office {
	public static void main(String[] args) {
		
	}
	public static void start(String str) {
		if(str.equals("Word")) {
			Word word=new Word();
			word.start();
		}
		if(str.equals("Excel")) {
			Excel e=new Excel() ;
			e.start();
		}
	}
}
