package bit.app.exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionEx2 {
	public void interruptedException() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(100);
				if (i % 7 == 0)
					System.out.println();
				System.out.printf("%5d", i);
				if (i % 5 == 0) {
					throw new InterruptedException();
				}
			} catch (InterruptedException e) {
				System.out.println("InterruptedException ...!");
				e.printStackTrace();
			}
		}
	}

	public void iOException() {
		FileInputStream fis = null;
		try {
//			File file = new File("d:\\abc");
//			file.mkdir();
//			file.createNewFile();
			fis = new FileInputStream(new File("d:\\data\\ExceptionEx1.java"));
			InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
			BufferedReader in = new BufferedReader(reader);
			int temp = 0;
			while ((temp = in.read()) != -1) { // eof값이 -1임
				Thread.sleep(1);
				System.out.print((char) temp);
			}
			System.out.println(System.in.read());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		ExceptionEx2 e = new ExceptionEx2();
//		e.interruptedException();
		e.iOException();
	}
}
