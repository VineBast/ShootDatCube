package ShootDatCube;

import com.jogamp.opengl.GL2;

public class Cube3D extends Shape3D {
	public Cube3D() {
		super();
	}

	public Cube3D(float x, float y, float z, float size, float r, float g, float b, boolean delete) {
		super.x = x;
		super.y = y;
		super.z = z;
		super.size = size;
		super.r = r;
		super.g = g;
		super.b = b;
		//Permet de notifier si c'est un cube visible ou non. Si delete est true, ça sera un cube noir (donc invisible sur fond noir)
		super.delete = delete;
	}

	public float getX() {
		return super.x;
	}

	public float getY() {
		return super.y;
	}

	public float getZ() {
		return super.z;
	}

	@Override
	public void display(GL2 gl) {
		// TODO Auto-generated method stub
		gl.glTranslatef(x, y, z);
		gl.glScalef(size, size, size);
		float ud = 1f;

		gl.glPopMatrix();		
		
		gl.glBegin(GL2.GL_QUADS);
		// Front
		gl.glColor3f(r, g, b);
		gl.glVertex3f(+ud, +ud, +ud);
		gl.glVertex3f(-ud, +ud, +ud);
		gl.glVertex3f(-ud, -ud, +ud);
		gl.glVertex3f(+ud, -ud, +ud);

		// Back
		gl.glColor3f(r, g, b);
		gl.glVertex3f(+ud, +ud, -ud);
		gl.glVertex3f(-ud, +ud, -ud);
		gl.glVertex3f(-ud, -ud, -ud);
		gl.glVertex3f(+ud, -ud, -ud);

		// Left & Right
		if (delete == true) {
			gl.glColor3f(r, g, b);
		} else {
			gl.glColor3f(r + 0.5f, g, b);
		}
		gl.glVertex3f(+ud, +ud, +ud);
		gl.glVertex3f(+ud, +ud, -ud);
		gl.glVertex3f(+ud, -ud, -ud);
		gl.glVertex3f(+ud, -ud, +ud);

		if (delete == true) {
			gl.glColor3f(r, g, b);
		} else {
			gl.glColor3f(r + 0.5f, g + 0.5f, b);
		}
		gl.glVertex3f(-ud, +ud, +ud);
		gl.glVertex3f(-ud, +ud, -ud);
		gl.glVertex3f(-ud, -ud, -ud);
		gl.glVertex3f(-ud, -ud, +ud);

		// Top & Bottom
		if (delete == true) {
			gl.glColor3f(r, g, b);
		} else {
			gl.glColor3f(r, g + 0.5f, b + 0.5f);
		}
		gl.glVertex3f(-ud, +ud, -ud);
		gl.glVertex3f(+ud, +ud, -ud);
		gl.glVertex3f(+ud, +ud, +ud);
		gl.glVertex3f(-ud, +ud, +ud);

		if (delete == true) {
			gl.glColor3f(r, g, b);
		} else {
			gl.glColor3f(r + 1f, g + 1f, b);
		}
		gl.glVertex3f(+ud, -ud, +ud);
		gl.glVertex3f(-ud, -ud, +ud);
		gl.glVertex3f(-ud, -ud, -ud);
		gl.glVertex3f(+ud, -ud, -ud);
		gl.glEnd();
		gl.glPopMatrix();
	}
}
