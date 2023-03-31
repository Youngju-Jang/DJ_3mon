package bit.basic.obj5;

import javax.swing.JButton;
import javax.swing.JFrame;

//InnerClass : Member Inner, Static Inner, Local Inner, AnonyMous
public class OuterClass extends JFrame{ 

	//// member 영역 ////
	private int outerValue; // member 변수 = 인스턴스 변수
	private int x;
	public OuterClass() {
		System.out.println("OuterClass()");
		System.out.println("outer x = " + x);
		System.out.println("outerValue = " + outerValue);
		this.setBounds(100,200,200,600);
	}
	private void outerMethod() {
		System.out.println("outerMethod");
		System.out.println("outer x = " + x);
		System.out.println("outerValue = " + outerValue);
	}
	
	// InnerClass
	public class Inner{ // Member Inner
		private int innerValue;
		private int x;
		public Inner() {
			System.out.println("Inner()");
//			this.setBounds(100,200,200,600); this 는 외부안가르킴
			setBounds(100,200,200,600); // 그냥 외부메소드 사용은 가능
		}
		public void innerMethod() {
			outerValue = 100; // outerValue
			OuterClass.this.x = 200; // 명시적 this
			x = 100; // innerValue
			outerMethod();
		}
	}
	public static void main(String[] args) {
		Inner inner = new OuterClass().new Inner();
		inner.innerMethod();
//		new Inner();
	}
	
	public void method() {
		new Inner();
	}
	
}
