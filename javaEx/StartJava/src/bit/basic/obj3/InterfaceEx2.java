package bit.basic.obj3;

public interface InterfaceEx2 {
	public abstract void interfaceEx2Method();
	public default void showDefaultMethod() {
		
	}
	public static void test() {};
	
	public static void main(String[] args) {
		InstanceClass test = new InstanceClass();
	}
}
