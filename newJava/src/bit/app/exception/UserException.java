package bit.app.exception;

public class UserException extends Exception{
	
	public UserException(String msg) {
		super(msg);
	}
	
	public void dataValidate() {
		System.out.println("dataValidate");
	}

}
