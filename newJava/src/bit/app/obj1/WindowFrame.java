package bit.app.obj1;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowFrame extends Frame {
	// component > container > window > frame
	
	public WindowFrame() {		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				WindowFrame.this.dispose();
			}
		});
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(e.getX() + " " + e.getY());
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println(e.getX() + " " + e.getY());
			}
		});
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getKeyChar());
			}
		});
		this.setBounds(100, 100, 500, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		WindowFrame w = new WindowFrame();
	}
}
