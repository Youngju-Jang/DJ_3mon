package bit.basic.obj2;

public class ActionForward {
	// 넘기기용
	private String path;
	private boolean redirect;
	
	public ActionForward(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	} 
	
	
	
}
