package controls;

import java.awt.event.KeyEvent;

import main.Game;
import main.GameState;
import player.Message;

public class ControlsPressedHandler {

	public static void handleInput(KeyEvent e) {
		if(Game.state == GameState.SPACE) {
			handleSpaceInput(e);
		}
		
		if(Game.state == GameState.TERRAIN) {
			handleTerrainInput(e);
		}
	}

	public static void handleSpaceInput(KeyEvent e) {
		
		//movement
		if(e.getKeyCode() == KeyEvent.VK_W && SpaceControls.forward != true) {
			SpaceControls.forward = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S && SpaceControls.back != true) {
			SpaceControls.back = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D && SpaceControls.right != true) {
			SpaceControls.right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_A && SpaceControls.left != true) {
			SpaceControls.left = true;
		}

		//spaceship
		if(e.getKeyCode() == KeyEvent.VK_E  ) {
			if(Game.player.rocket.inertdamp) {
				Game.player.rocket.inertdamp = false;
				Message.dampenersOnTime = -1;
				Message.dampenersOffTime = System.currentTimeMillis();
			}else {
				Game.player.rocket.inertdamp = true;
				Message.dampenersOffTime = -1;
				Message.dampenersOnTime = System.currentTimeMillis();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE && !SpaceControls.shoot) {
			SpaceControls.shoot = true;
		}
	}

	public static void handleTerrainInput(KeyEvent e) {
		//movement
		if(e.getKeyCode() == KeyEvent.VK_W && TerrainControls.forward != true) {
			TerrainControls.forward = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S && TerrainControls.back != true) {
			TerrainControls.back = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D && TerrainControls.right != true) {
			TerrainControls.right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_A && TerrainControls.left != true) {
			TerrainControls.left = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE && !TerrainControls.shoot) {
			TerrainControls.shoot = true;
		}
	}

}
