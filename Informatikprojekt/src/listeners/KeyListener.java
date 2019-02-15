package listeners;

import java.awt.event.KeyEvent;

import controls.ControlsPressedHandler;
import controls.ControlsReleasedHandler;
import main.Game;

public class KeyListener implements java.awt.event.KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		//game
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			Game.running = false;
		}
		
		ControlsPressedHandler.handleInput(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		ControlsReleasedHandler.handleInput(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
