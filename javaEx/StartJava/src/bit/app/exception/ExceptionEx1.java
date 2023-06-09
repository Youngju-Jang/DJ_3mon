package bit.app.exception;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

public class ExceptionEx1  {
	
	public void arithmeticException() {
//		System.out.println((int)(Math.random()*100%50));
//		Random random = new Random();
//		int rs = random.nextInt(10);
//		System.out.println(rs);
//		System.out.println(random.nextBoolean());
		int[] m = new int[5];
		for(int i=0; i<m.length; i++) {
//			m[i] = (int)Math.random() * 100; // m[i] 에 0만들어감
			m[i] = (int)(Math.random() * 100); // m[i] 에 0만들어감
			int rs = 100/m[i]; 
		}
	}
	
	public void numberFormatException(String message) {
		int x = 0;
		int y = 0;
		try {
			if(message.startsWith("[STONE]")) {
				System.out.println("GAME ...");
				String[] xy = message.substring(message.indexOf("]")+1).split(" ");
				x = Integer.parseInt(xy[0].split("=")[1]);
				y = Integer.parseInt(xy[1].split("=")[0]); // > numberFormatException 발생
				System.out.println("x = " +x + ", y = " + y);
			}else if(message.startsWith("[ROOM]")) {
				System.out.println("ROOM ...");
			}
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			System.out.println("x = " +x + ", y = " + y);
		}
		
	}
	public void nullPointerException1(int x, int y, int z) {
		String str = null;
		try {
			if((5<=(x+y+z)) && ((x+y+z)<10)) {
				str = "Java";
			}
			System.out.println(str.substring(0));
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			str = "Oracle";
			System.out.println(str.substring(0));
			System.out.println("finally");
		}
	}
	
	public void nullPointerException2() {
		String s = null;
		try {
			s = s.toUpperCase();
			System.out.println(s);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			s = "empty";
			System.out.println(s.toUpperCase());
		}finally {
			System.out.println("실행되라얍");
		}
	}

	public void arrayIndexOutOfBoundsException() {
		int[] m = new int[5];
		for(int i=0; i<= m.length; i++) {
			try {
				m[i] = 100;
				System.out.println("i : "+i +", Data="+m[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
			finally {
				System.out.println("finally");
			}
		}
	}
	
	public void stringIndexOutOfBoundsException(String value) {
		System.out.println(value.substring(1, 4)); //bcd
		System.out.println(value.substring(3, 4)); //d
		System.out.println(value.substring(4, 2)); //exception
	}
	
	public void cloneNotSupportedException() {
		Vector<String> v1 = new Vector<String>();
		Vector<String> v2 = new Vector<String>();
		v1.add("달기");
		v1.add("수박");
		System.out.println(v1.clone());
	}
	
	public void noSuchElementException() {
		ArrayList<Integer> list1 = new ArrayList<Integer>(); // LIST
		HashSet<Integer> hs = new HashSet<Integer>(); // SET
		list1.add(10);
		list1.add(20);
		list1.add(30);
		
		hs.add(10);
		hs.add(20);
		hs.add(30);
		hs.add(40);
		hs.add(40);
		hs.add(40);
		System.out.println(list1);
		System.out.println(hs);
		
		Iterator<Integer> i = list1.iterator();
		hs.iterator();
//		System.out.println(i.next());
//		System.out.println(i.next());
//		System.out.println(i.next());
//		System.out.println(i.next());
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		for(;i.hasNext();) {
			System.out.println(i.next());
		}
		for(Integer e : list1) {
			System.out.println(e);
		}
		Iterator<Integer> itor = hs.iterator();
		
	}
	
	public static void main(String[] args) {
		ExceptionEx1 e = new ExceptionEx1();
		e.noSuchElementException();
//		e.cloneNotSupportedException();
//		e.stringIndexOutOfBoundsException("abcd");
//		e.arrayIndexOutOfBoundsException();
//		e.arithmeticException();
//		e.numberFormatException("[STONE]x=150 y=300");
//		e.numberFormatException("[ROOM]안녕하세요");
//		e.nullPointerException1(1,2,1);
//		e.nullPointerException2();
		
	}
}
