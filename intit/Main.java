package intit; 
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import gui.*;
import java.awt.event.KeyListener;
public class Main extends JFrame implements KeyListener{
	public static DragPanel d;
	public static JTextField type;
	public Main(String s) {
		super(s);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main s;
		s=new Main("app");
		s.setSize(600,400);

		s.methodAddBits();
		s.setLocationRelativeTo(null);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setResizable(true);
		s.setVisible(true);
		
	}
	private void methodAddBits() {
		d=new DragPanel(600,400);
		type=new JTextField("");
		type.addKeyListener(this);
		getContentPane().addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent evt) {
				Component c=(Component)evt.getSource();
				d.resizes(getContentPane().getSize().width, getContentPane().getSize().height);
			}
			
		});
		getContentPane().add(type);
		getContentPane().add(d);
		type.requestFocus();

		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		Main.d.panel.moveCam(1,0);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
