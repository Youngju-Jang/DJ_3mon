package bit.app.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteStreamEx {

	public void streamEx1() throws IOException {
		System.out.println("Data: ");
		byte[] contents = new byte[100];
//		System.in.read(contents);
		int rc = System.in.read(contents);
		System.out.println("rc =" + rc);
//		for(byte b:contents) {
//			System.out.print(b+" ");
//		}
		System.out.println(new String(contents).trim());
	}
	public void fileCopy() {
		BufferedReader br = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int temp = 0;
		int size = 0;
		try {
			System.out.println("FileOrigin: ");
			br = new BufferedReader(new InputStreamReader(System.in)); // file 위치쓰기 c:\\test\test.txt
			fis = new FileInputStream(new File(br.readLine().trim()));
			System.out.println("FileChange: ");
			fos = new FileOutputStream(new File(br.readLine().trim())); // 새 파일 저장위치
			while((temp = fis.read())!= -1) {  
				fos.write(temp);
				size++;
			}
			System.out.println(size+"byte FileCopy Success!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) br.close();
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	// close 자동으로 되도록
	public void fileCopy(String origin, String change) {
		int temp = 0;
		int size = 0;
		try(FileInputStream fis = new FileInputStream(origin);
			FileOutputStream fos = new FileOutputStream(change);){
			
			while((temp = fis.read())!= -1) {  
				fos.write(temp);
				size++;
			}
			System.out.println(size+"byte FileCopy Success!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fileBufferCopy(String origin, String change) {
		byte[] cp = new byte[300];
		try(
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(origin)));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(change)));){
			
			bis.read(cp);
			bos.write(new String(cp).trim().getBytes());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception{
		ByteStreamEx b = new ByteStreamEx();
//		b.streamEx1();
		b.fileBufferCopy("c:\\test\\test.txt", "c:\\test\\text2.txt");
	}
}
