package bit.basic.obj4;

public class StaticEx1 {
	static int data;
	
	public void show() {
		System.out.println("run StaticEx1-show()");
	}
	
	public static void staticShow() {
		System.out.println("run StaticEx1-staticShow()");
	}
	
	public static void main(String[] args) {
		StaticEx1 e = new StaticEx1();
		e.show();
		
		staticShow();
		StaticEx1.data = 10;
		
	}
}
