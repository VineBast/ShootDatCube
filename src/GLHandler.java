package ShootDatCube;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class GLHandler implements GLEventListener {
	protected GLU glu;
	protected float angle;
	protected boolean more = true;
	protected float posX = -1000;
	protected float posY = -1000;
	protected ArrayList<Shape3D> items3D;

	public GLHandler() {
		this.glu = new GLU();
		this.angle = 0;
		this.items3D = new ArrayList<Shape3D>();
		// Création des cubes
		this.items3D.add(new Cube3D(0, 0, -3, 1f, 0f, 1f, 1f, false));
		this.items3D.add(new Cube3D(4, 0, -3, 1f, 0.5f, 1f, 0.5f, false));
		this.items3D.add(new Cube3D(0, 4, -3, 1f, 1f, 1f, 0f, false));
		this.items3D.add(new Cube3D(0, -9, -3, 1f, 1f, 0f, 1f, false));
		this.items3D.add(new Cube3D(-4, 0, 0, 1f, 0f, 0f, 1f, false));
		this.items3D.add(new Cube3D(-4, -1, -3, 1f, 0.5f, 0.5f, 0.5f, false));
		this.items3D.add(new Cube3D(-4, 5, -3, 1f, 0.5f, 0.5f, 1f, false));
		this.items3D.add(new Cube3D(-4, 9, -3, 1f, 1f, 1f, 1f, false));
		this.items3D.add(new Cube3D(7, 1, -3, 1f, 1f, 0.5f, 1f, false));
	}

	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
	}

	@Override
	public void dispose(GLAutoDrawable glAutoDrawable) {
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(0.0f, 0.0f, -7.0f);
		gl.glRotatef(angle, 0f, 0f, 1f);
		
		for (Shape3D s : this.items3D)
			s.display(gl);
		suppr();
		//Modifie la valeur angle pour faire un mouvement de va-et-vient
		if (angle > 10) {
			more = false;
		} else if (angle < 0) {
			more = true;
		}
		if (more == true) {
			this.angle += 0.1;
		} else if (more == false) {
			this.angle -= 0.1;
		}
	}
	//Fonction qui regarde si l'user a cliqué sur un cube grâce aux valeurs "posX" et "posY" modifiées par UserMouse
	//elle remplace le cube cible par un cube noir, donc invisible sur fond noir
	//cette fonction est appelée à chaque display()
	public void suppr() {
		if ((posX > 300 && posX < 500) && (posY > 200 && posY < 375)) {
			items3D.set(0, (new Cube3D(0, 0, -3, 1f, 0f, 0f, 0f, true)));
			rebootPos();
		} else if ((posX > 546 && posX < 706) && (posY > 215 && posY < 375)) {
			items3D.set(1, (new Cube3D(4, 0, -3, 1f, 0f, 0f, 0f, true)));
			rebootPos();
		} else if ((posX > 485 && posX < 642) && (posY > 22 && posY < 173)) {
			items3D.set(2, (new Cube3D(0, 4, -3, 1f, 0f, 0f, 0f, true)));
			rebootPos();
		} else if ((posX > 510 && posX < 637) && (posY > 422 && posY < 541)) {
			items3D.set(3, (new Cube3D(0, -9, -3, 1f, 0f, 0f, 0f, true)));
			rebootPos();
		} else if ((posX > 355 && posX < 472) && (posY > 438 && posY < 545)) {
			items3D.set(4, (new Cube3D(-4, 0, 0, 1f, 0f, 0f, 0f, true)));
			rebootPos();
		} else if ((posX > 227 && posX < 340) && (posY > 465 && posY < 550)) {
			items3D.set(5, (new Cube3D(-4, -1, -3, 1f, 0f, 0f, 0f, true)));
			rebootPos();
		} else if ((posX > 121 && posX < 637) && (posY > 134 && posY < 526)) {
			items3D.set(6, (new Cube3D(-4, 5, -3, 1f, 0f, 0f, 0f, true)));
			rebootPos();
		} else if ((posX > 18 && posX < 117) && (posY > 66 && posY < 193)) {
			items3D.set(7, (new Cube3D(-4, 9, -3, 1f, 0f, 0f, 0f, true)));
			rebootPos();
		} else if ((posX > 224 && posX < 305) && (posY > 58 && posY < 141)) {
			items3D.set(8, (new Cube3D(7, 1, -3, 1f, 0f, 0f, 0f, true)));
			rebootPos();
		}
	}
	//Remet les valeurs globales à leur valeur par défaut
	public void rebootPos() {
		posX = -1000;
		posY = -1000;
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GL2 gl = drawable.getGL().getGL2();
		// Taille de la fenêtre
		float aspect = (float) width / height;
		// Set the view port (display area) : la taille utilisée à l'intérieur
		gl.glViewport(0, 0, width, height);
		// CAMERA
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		// Objet GLU pour utiliser ses fonctions
		glu = new GLU();
		// FOCAL , ASPECT, Zoom min, Zoom max
		glu.gluPerspective(45.0, aspect, 0.1, 100.0);
		// Enable the model-view transform
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();

	}
	//Permet de changer les valeurs des posX et posY à l'extérieur de cette classe
	public void changeX(float x) {
		this.posX = x;
	}
	public void changeY(float y) {
		this.posY = y;
	}

}