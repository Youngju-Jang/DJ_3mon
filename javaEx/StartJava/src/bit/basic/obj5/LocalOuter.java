package bit.basic.obj5;

import javax.swing.JPanel;

public class LocalOuter extends JPanel{
	private int value; // instance value
	private static final int DATA = 100;
	// member inner class
	public class MemberInner{
		private int innerValue;
		public MemberInner() {
			System.out.println(DATA); // 외부 상수 접근가능
		}
	}
	public void method1(int test) {
		int localValue = 10;
		final int FINALVALUE = 10;
		// local inner class
		class LocalInner {
			// 생성자
			public LocalInner() {
				value = 10; 
				// this.value = 10; 접근불가
				
			} // 생성자
			
			// local inner method
			public void showLocal() {
				value = localValue; // outer instance value
				value = 10 + test;
				System.out.println(DATA); // 외부 상수 접근가능
//				localValue = 100; // local value 접근x
				System.out.println(FINALVALUE);
			}
		}// local inner class
		LocalInner in = new LocalInner();
	}// outer class

	public static void main(String[] args) {
		LocalOuter local = new LocalOuter(); 
		local.method1(10);
	}
}
