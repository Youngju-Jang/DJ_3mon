package bit.basic.collection;

import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;

public class ListEx3 {
	
	public void listEx1() {
		Vector<Integer>list=new Vector<Integer>();
		Integer []i= {1,2,3,4,5,6,7,8,9,10};
//		list.add(0,10);
//		list.add(2,10);
//		System.out.println(list);
		//listt.add(i[0]);
		for (int j = 0; j < i.length; j++) {
			list.add(j, i[j]);
		}
//		System.out.println(list.get(0));
//		System.out.println(list.elementAt(9));
		
//		Iterator<Integer>ir= list.iterator();
//		for(;ir.hasNext();) {
//			System.out.println(ir.next());
//		}
//		Enumeration<Integer>e= list.elements();
//		while(e.hasMoreElements()) {
//			System.out.println(e.nextElement());
//		}
		StringTokenizer st=new StringTokenizer("java oracle mySal Servlet");
		System.out.println(st.countTokens());
		while(st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}
	}	
	public void listEx2() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(10);
		stack.add(20);
		stack.add(30);
		stack.add(40);
		stack.push(50);
//		stack.push(10);
		System.out.println(stack.peek());
		System.out.println(stack.peek());
//		System.out.println(stack.pop());
		System.out.println(stack.search(10));// 뒤에서부터 1234 (size - lastIndexOf())
		System.out.println(stack.indexOf(10)); // 앞에서부터 0123 인데 처음꺼
		System.out.println(stack.lastIndexOf(10));// 앞에서부터 0123 인데 마지막꺼
		
		
	}
	public static void main(String[] args) {
		ListEx3 list=new ListEx3();
		list.listEx2();
		
	}
	

}
