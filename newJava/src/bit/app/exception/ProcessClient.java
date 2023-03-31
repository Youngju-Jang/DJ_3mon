package bit.app.exception;

public class ProcessClient {

//	Process p; 
//	public static Process p = new Process();
//	Process p = new Process(); 
	ProcessInter p = new Process();
	
	public void action1() {
		p.fileCheck(); // nullPointerException 발생함
		System.out.println("action");
	}
	
	public void action2() {
		
	}
	public void action3() {}
	
	public static void main(String[] args) {
		ProcessClient p = new ProcessClient();
		p.action1();
	}
}
