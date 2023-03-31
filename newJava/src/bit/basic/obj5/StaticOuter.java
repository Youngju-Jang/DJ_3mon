package bit.basic.obj5;

public class StaticOuter {
	private static int outerStaticValue;
	private int instanceOuterValue;
	
	public static class StaticInner{
		private int innerValue;
		public StaticInner() {
			outerStaticValue = 100;
//			instanceOuterValue = 100;
		}
		public void innerMethod() {
			int value;
		}
	}// inner
	
	public static void main(String[] args) {
//		 new StaticOuter().new StaticInner(); 이미 만들어져서 이렇게안하도록 막음
		StaticInner inner = new StaticInner();
	}
}// outer
