package bit.app.obj1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowFrame2 extends Frame{
	Dimension d = Toolkit.getDefaultToolkit().getDefaultToolkit().getScreenSize();
	static final int SQUAREWIDTH = 60;
	private Pan pan = new Pan(); // component
	public WindowFrame2() {
		this.add(pan);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setUndecorated(true);
//		Dimension d = Toolkit.getDefaultToolkit().getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, d.width, d.height);
		this.setVisible(true);
	}
	
	public class Pan extends Canvas{
		public Pan() {
			this.setBackground(Color.YELLOW);
		}

		@Override
		public void paint(Graphics g) {
			// 바둑판그리기
			int startI = (d.width%SQUAREWIDTH ==0)? SQUAREWIDTH/2 : (d.width%SQUAREWIDTH)/2;
			int startJ = (d.height%SQUAREWIDTH ==0)? SQUAREWIDTH/2 : (d.height%SQUAREWIDTH)/2;
			for(int i=startI; i<= d.width-startI-SQUAREWIDTH; i+=SQUAREWIDTH) {
				for(int j=startJ; j<=d.height-startJ-SQUAREWIDTH; j+=SQUAREWIDTH) {
					g.drawRect(i, j, SQUAREWIDTH, SQUAREWIDTH);
				}
			}
		}

		@Override
		public void update(Graphics g) {
			// TODO Auto-generated method stub
			super.update(g);
		}
		
	}
	public static void main(String[] args) {
		new WindowFrame2();
	}
	
}
