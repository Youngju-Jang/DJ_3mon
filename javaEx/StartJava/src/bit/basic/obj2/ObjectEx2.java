package bit.basic.obj2;
// static, final, access(public > protected > default > private) 
public class ObjectEx2 {
	// 싱글톤패턴
	// 접근제어자가 private인경우 
	private String message;	
	private static ObjectEx2 instance;
	
	public static ObjectEx2 getInstance() {
		if(instance==null) {
			instance = new ObjectEx2();
		}
		return instance;
	}
	
	private ObjectEx2() {
		message="hi";
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
