package bit.basic.obj1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;


// 다형성
public class ObjectEx4 {
	public InputStream getBufferInput() throws Exception{
		
		return new FileInputStream(new File(""));
	}
	public List getList() {
		return new Stack();
	}
	public void methodObj1() {
		System.out.println("Data : "); 
//		BufferedInputStream bis = null;
		BufferedReader br = null;
		try {
//			bis = new BufferedInputStream(new FileInputStream(new File(new StringBuffer().toString())));
//			br = new BufferedReader(System.in);
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(br.readLine());
//			System.out.println(System.in);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void methodObj2(Object value) {
		if(value instanceof Double) {
			System.out.println(((Double)value).doubleValue());
		}
		if(value instanceof String) {
			System.out.println(((String)value).substring(0));
		}
	}	
	public void methodObj3() {
		Float flot = 10.7F;		
	}
	public static void main(String[] args) {
		ObjectEx4 o = new ObjectEx4();
		o.methodObj2("10");
	}
}
