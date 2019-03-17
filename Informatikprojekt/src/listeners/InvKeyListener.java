package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;

public class InvKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			Game.inventory.setVisible(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
