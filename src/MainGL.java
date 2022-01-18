package ShootDatCube;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.jogamp.newt.event.MouseAdapter;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

public class MainGL {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setResizable(false);
		GLCanvas canvas = new GLCanvas();
		GLHandler events = new GLHandler();
		canvas.addMouseListener(new UserMouse(events));
		canvas.setPreferredSize(new Dimension(800, 600));
		canvas.addGLEventListener(events);
		frame.getContentPane().add(canvas);
		frame.setTitle("ShootDatCube");
		frame.pack();
		frame.setVisible(true);
		FPSAnimator anim = new FPSAnimator(canvas, 60);
		anim.start();
	}
}
