package listeners;

import java.awt.event.MouseEvent;

import controls.TerrainMouse;
import tools.Vector2;

public class MouseMotionListener implements java.awt.event.MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {
		TerrainMouse.mousePos = new Vector2(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

}
