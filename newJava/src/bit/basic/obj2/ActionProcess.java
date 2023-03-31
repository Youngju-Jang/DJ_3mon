package bit.basic.obj2;

import java.util.Scanner;

// 여기가 메인
public class ActionProcess {
	private Scanner scanner = new Scanner(System.in);
	
	public void menu() {
		String command = "";
		while(true) {
			System.out.println("1.Login 2.List 3.Delete 4.Modify 5.Exit ");
			switch (scanner.nextInt()) {
			case 1: 
				command = "login"; break;
			case 2: 
				command = "list"; break;
			case 3: 
				command = "delete"; break;
			case 4: 
				command = "modify"; break;
			case 5: 
				return;
			}
//			new ActionFactory().getAction(command) // 이렇게하면 로그인할때마다 객체생성되버림
			Action action = ActionFactory.getInstance().getAction(command);
			ActionForward af = action.execute(); // BL 수행
			if(af.isRedirect()) {
				System.out.println(af.getPath() + "로 직접이동");
			}else {
				System.out.println(af.getPath() + "로 간접이동");
			}
		}// while
	}
	
	public static void main(String[] args) {
		new ActionProcess().menu();
	}
}
