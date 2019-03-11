package listeners;

import java.awt.event.MouseEvent;

import controls.MousePressedHandler;
import controls.MouseReleasedHandler;

public class MouseListener implements java.awt.event.MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		
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
	public void mousePressed(MouseEvent e) {
		MousePressedHandler.handleInput(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MouseReleasedHandler.handleInput(e);
	}

}
