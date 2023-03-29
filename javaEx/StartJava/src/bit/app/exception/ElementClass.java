package bit.app.exception;

public class ElementClass implements Cloneable{
	private int count;
	private String msg;
	
	
	public ElementClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ElementClass(int count, String msg) {
		super();
		this.count = count;
		this.msg = msg;
	}
	public void method() {
		ElementClass et = new ElementClass(100, "class");
		System.out.println(et);
		try {
			System.out.println(et.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ElementClass count :" + count + ", msg : " + msg;
	}
	public static void main(String[] args) {
		ElementClass e= new ElementClass();
		e.method();
	}
	
}
