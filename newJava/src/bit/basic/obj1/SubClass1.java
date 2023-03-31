package bit.basic.obj1;

public class SubClass1 extends SuperClass{
	
	private int subClass1Value;
	
	public SubClass1() {
	}
	
	public SubClass1(int superClass1Value, int subClass1Value) {
		super(superClass1Value);
		this.subClass1Value = subClass1Value;
		System.out.println("서브");
	}
	
	@Override
	public void actionProcess() {
		System.out.println("SubClass1 actionProcess");
	}	
	
	public void sub1Action() {
		System.out.println("sub1Action");
	}
}
