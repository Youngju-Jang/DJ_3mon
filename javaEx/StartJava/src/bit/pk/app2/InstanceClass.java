package bit.pk.app2;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;
import bit.pk.app1.Super;

public class InstanceClass {
	// 다른패키지. 후손x
	public InstanceClass() { // 후손생성자
		Super su = new Super();
		su.publicData = 10;
//		su.protectedData = 10;
//		su.defaultData = 10;
//		su.privateDate = 10;
		ArrayList<?> a = new ArrayList<>();
		Vector v = new Vector();
		Stack<String> s = new Stack<String>();
		
	}
}
