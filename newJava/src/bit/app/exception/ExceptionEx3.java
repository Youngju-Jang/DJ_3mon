package bit.app.exception;

import java.io.IOException;

public class ExceptionEx3 {

	public void exceptionEx1() throws IOException, InterruptedException, CloneNotSupportedException{
		System.in.read();
		Thread.sleep(1000);
		this.clone();
	}
	public void exceptionEx2() throws IOException, InterruptedException, CloneNotSupportedException{
		exceptionEx1();                          
	}                                            
	public void exceptionEx3() throws IOException, InterruptedException, CloneNotSupportedException{
		exceptionEx2();
	}
	public static void main(String[] args) throws Exception{
		ExceptionEx3 e = new ExceptionEx3();
		e.exceptionEx3();
	}
}
