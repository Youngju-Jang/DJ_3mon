package bit.basic.obj2;

public class ObjectEx1 {
	private static final int CNT;
	static {
		CNT = 90;
	}
	public ObjectEx1() {
//		cnt = 90;
	}
	public static void main(String[] args) {
		ObjectEx1 o1 = new ObjectEx1(); // cnt 90
		System.out.println(ObjectEx1.CNT);
		System.out.println(Integer.MIN_VALUE+"~"+Integer.MAX_VALUE);
	}

}
