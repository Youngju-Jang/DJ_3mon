package bit.basic.obj5;

import java.util.ArrayList;

import javax.swing.JFrame;

public class WindowEx3 extends JFrame{
	private ArrayList<String> list = new ArrayList<String>() {
		@Override
		public String toString() {
			return "this toString";
		}
	};
	
	public void actionString() {
//		System.out.println(this.toString());
		System.out.println(list.toString()); // "this toString"
		System.out.println(toString());
	}

	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "WindowEx3 toString";
//	}


	public static void main(String[] args) {
		WindowEx3 w = new WindowEx3();
		w.actionString();
		System.out.println(w.toString());
	}
}
