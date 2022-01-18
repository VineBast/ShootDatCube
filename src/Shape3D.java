package ShootDatCube;
import com.jogamp.opengl.GL2;

public abstract class Shape3D {
	protected float x, y, z, size;
	protected float r, g, b;
	protected boolean delete;
	
	public Shape3D() {
		x = 0;
		y = 0;
		z = 0;
		size = 0;
		r = 0;
		g = 0;
		b = 0;
		delete = false;
	}
	
	public Shape3D(float x, float y, float z, float size, float r, float g, float b, boolean delete) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.size = size;
		this.delete = delete;
	}
	public abstract float getX();
	public abstract float getY();
	public abstract float getZ();
	
	public abstract void display(GL2 gl);
}

