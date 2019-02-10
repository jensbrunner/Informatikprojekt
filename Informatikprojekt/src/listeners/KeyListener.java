package listeners;

import java.awt.event.KeyEvent;

import player.Controls;

public class KeyListener implements java.awt.event.KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP && Controls.forward != true) {
			Controls.forward = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN && Controls.back != true) {
			Controls.back = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && Controls.right != true) {
			Controls.right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT && Controls.left != true) {
			Controls.left = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP && Controls.forward == true) {
			Controls.forward = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN && Controls.back == true) {
			Controls.back = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && Controls.right == true) {
			Controls.right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT && Controls.left == true) {
			Controls.left = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
