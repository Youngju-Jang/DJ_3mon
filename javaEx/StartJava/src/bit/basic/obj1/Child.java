package bit.basic.obj1;

class Parent {
	String val1;
	String val;
	
//	public Parent() {
//		this.val1 = "엄마";
//		this.val = "parent";
//	}
	public Parent(String val) {
		this.val1 = "할머니";
		this.val = val;
	}

}

public class Child extends Parent{
	
//	public Child() {
////		super();
//		this.val = "child";
//			
//	}
	
	public Child(String val) {
		super("할아버지");
		this.val += val;
	}
	
	public static void main(String[] args) {
		Parent p = new Child("아빠");
		System.out.println(p.val1);
		System.out.println(p.val);
	}

}
 