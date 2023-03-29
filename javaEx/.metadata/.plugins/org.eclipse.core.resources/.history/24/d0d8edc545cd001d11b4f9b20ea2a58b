package bit.app.obj1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowFrame2 extends Frame{
	private Pan pan = new Pan();
	public WindowFrame2() {
		this.add(pan);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setUndecorated(true);
		Dimension d = Toolkit.getDefaultToolkit().getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, d.width, d.height);
		this.setVisible(true);
	}
	
	public class Pan extends Canvas{
		public Pan() {
			this.setBackground(Color.YELLOW);
		}
	}
	public static void main(String[] args) {
		new WindowFrame2();
	}
	
}
