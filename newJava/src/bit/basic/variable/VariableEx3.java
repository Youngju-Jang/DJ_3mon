package bit.basic.variable;

// byte short int long / 
public class VariableEx3 {
	public void typeMethod1() {
		byte x1 = 10;
		byte x2 = 20;
		byte x3 = (byte)(x1+x2);
		int rs = Integer.MAX_VALUE; // 2147483647
		int rs2 = Integer.MAX_VALUE+1; // -2147483647
		long lg1 = Integer.MAX_VALUE+1; // -2147483647 연산시 둘다 int라 int형
		long lg2 = Integer.MAX_VALUE+1L; // 2147483648
		
		System.out.println(rs);
		
		float f = 10.5F;
		System.out.println(f);
	}
	
	public int typeMethod2(int x, int y, int z) {
		
		return (x+y);
	}
	
	public static void main(String[] args) {
		VariableEx3 v3 = new VariableEx3();
		v3.typeMethod1();
	}
}
