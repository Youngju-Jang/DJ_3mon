package bit.basic.obj1;

public class SuperClass {
	private int superClassValue;
	
	public SuperClass() {
		super();
		System.out.println("기본");
	}
	
	public SuperClass(int superClassValue) {
		this.superClassValue = superClassValue;
		System.out.println("기본 + 파람");
		
	}
	
	public void actionProcess() {
		System.out.println("actionProcess");
	}
	
	public void sub3Action() {
		System.out.println("sub3Action");
	}
	
	
}
