package ShootDatCube;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UserMouse implements MouseListener {
	private GLHandler events;
	
	public UserMouse(GLHandler events) {
		this.events = events;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		//Modifie les valeurs des posX et posY grâce à l'event GLHandler passé en argument
		this.events.changeX(mouseEvent.getX());
		this.events.changeY(mouseEvent.getY());

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}