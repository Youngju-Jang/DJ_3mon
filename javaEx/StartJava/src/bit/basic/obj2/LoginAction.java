package bit.basic.obj2;

public class LoginAction extends Action{
	
	private String path;
	private boolean redirect; // 직접이동 / 간접이동
	
	public LoginAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}


	@Override
	public ActionForward execute() {
		System.out.println("LoginAction");
		return new ActionForward(path, redirect);
	}
}
