package bit.basic.obj5;

public class AnonyMousEx {
	
	private int x, y;
	
	// AnonyMous inner class
	private AbleInterface i = new AbleInterface() {
		int yy;
		@Override
		public void validate() {
			System.out.println("validate()");
		}
		
		@Override
		public void fileOpen() {
			
		}
		
		@Override
		public void fileCheck() {
			System.out.println("fileCheck");
			// this.x 안됨
			x = 99; // 이건됨. outer 의 x
		}
	};// inner
	
	public void anonymousMethod1() {
		i.fileCheck();
		
	}// outer
	
	public static void main(String[] args) {
		AnonyMousEx a = new AnonyMousEx();
		a.anonymousMethod1();
	}
}
