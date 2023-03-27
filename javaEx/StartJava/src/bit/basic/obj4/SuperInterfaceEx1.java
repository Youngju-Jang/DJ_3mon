package bit.basic.obj4;

public interface SuperInterfaceEx1 {
	
	static final int a = 100;
	public default void show() {
		System.out.println("show");
	}
	public void interAbstract();
}
