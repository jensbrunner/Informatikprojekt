package listeners;

import java.awt.event.MouseWheelEvent;

import player.Camera;

public class MouseWheelListener implements java.awt.event.MouseWheelListener {

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e.getWheelRotation() == -1) {
			Camera.zoomFactor*=1.1;
		}else {
			Camera.zoomFactor*=0.9;
		}
	}

}
