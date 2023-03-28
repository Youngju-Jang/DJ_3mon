package bit.basic.obj5;

import javax.swing.JFrame;

public class WindowEx2 extends JFrame{
	private int x;
	public WindowEx2() {
		// anonymous
		new MouseAdapterEx() {

			@Override
			public void mouseClick() {
				x= 100;
			}
			
		};
	}
	
}
