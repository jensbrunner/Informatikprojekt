package listeners;

import java.awt.event.MouseWheelEvent;

import main.Game;
import player.Camera;

public class MouseWheelListener implements java.awt.event.MouseWheelListener {

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		/*if(e.getWheelRotation() == -1) {
			Game.player.cam.zoomFactor*=1.1;
		}else {
			Game.player.cam.zoomFactor*=0.9;
		}*/
	}

}
