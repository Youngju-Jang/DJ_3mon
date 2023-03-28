package bit.basic.obj5;

public class InstanceMember extends SuperInstanceMember{
	
	private int x;
	
	public InstanceMember() {
//		this.superValidate();
//		superValue=100;
	}
	public void outerMemberMethod() {
		System.out.println("x = " + x);
	}
	
	public class Inner{ // object
		private int x;
		public Inner() {
			this.x = 200;
			InstanceMember.this.x = 100; // 외부 x 접근
			
//			superValue=100;
			superValidate();
			outerMemberMethod();
			
			InstanceMember.this.superValidate();
		}
	}// inner
	
	public static void main(String[] args) {
		InstanceMember.Inner inner = new InstanceMember().new Inner();
	}
}// outer
