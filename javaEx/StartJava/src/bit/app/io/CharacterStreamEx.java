package bit.app.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Scanner;

public class CharacterStreamEx {

	public void fileCopy() {
		try(
			Scanner scanner = new Scanner(new File("c:\\test\\test.txt"));
			BufferedOutputStream bos = new BufferedOutputStream(new PrintStream(new File("c:\\test\\testCopy.txt")));
				) {
		while(scanner.hasNext()) {
//			Thread.sleep(100);
//			System.out.println(scanner.nextLine());
//			System.out.println(scanner.next()); // 스페이스 기준인듯
//			bos.write(scanner.nextLine().getBytes()); // 버퍼양이 다 차지않으면 안보냄
			bos.write(scanner.nextLine().concat("\r\n").getBytes()); // 버퍼양이 다 차지않으면 안보냄
			bos.flush(); // 원랜 8192가 차야 비워줌
		}
		System.out.println("FileCopy Success!");
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		}
	}
	
	public void fileScanner() {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		BufferedWriter bw = null;
		String temp = "";
		try {
			
			System.out.println("OriginFile: ");
			br = new BufferedReader(new FileReader(new File(sc.nextLine().trim())));
			System.out.println("ChangeFile: ");
			bw = new BufferedWriter(new FileWriter(new File(sc.nextLine().trim())));
			while((temp= br.readLine())!=null){
				bw.write(temp);
				bw.flush();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) br.close();
				if(bw!=null) bw.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args)  {
		CharacterStreamEx c = new CharacterStreamEx();
//		c.fileCopy();
		c.fileCopy();
	}
}
