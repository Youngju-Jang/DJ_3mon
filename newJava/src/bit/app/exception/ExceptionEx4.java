package bit.app.exception;

import java.util.Scanner;

public class ExceptionEx4 {

	
	Scanner scanner = new Scanner(System.in);
	
	public void exceptionAction() {
		System.out.println("Data Input : ");
		int value = scanner.nextInt();
		try {
			if(100 <=value || value<0) {
				throw new UserException("양수 0~100까지만");
			}
		}catch (UserException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ExceptionEx4 e = new ExceptionEx4();
		e.exceptionAction();
	}
}
