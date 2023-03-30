package bit.basic.collection;

import java.util.HashSet;
import java.util.Iterator;

public class SetEx1 {
	public void setProcess1() {
		String[] lesson = {"JAVA", "DATABASE", "SERVLET","JAVA", "DATABASE"};
		HashSet<String> set1 = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
		
		for(int i=0; i<lesson.length; i++) {
			if(!set1.add(lesson[i])) {
				set2.add(lesson[i]);
			}
		}
//		for(String item : set1) {
//			System.out.println(item);
//		}
		Iterator<String> i = set1.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
		
		HashSet<String> set3 = (HashSet<String>)set2.clone();
//		set3.clear();
//		System.out.println(set3.contains("JAVA"));
//		System.out.println(set2.contains("JAVA"));
		set1.remove("JAVA");
		System.out.println(set1);
	}
	public static void main(String[] args) {
		SetEx1 e = new SetEx1();
		e.setProcess1();
	}
}
