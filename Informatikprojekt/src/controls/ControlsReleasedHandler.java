package controls;

import java.awt.event.KeyEvent;

import main.Game;
import main.GameState;

public class ControlsReleasedHandler {

	public static void handleInput(KeyEvent e) {
		if(Game.state == GameState.SPACE) {
			handleSpaceInput(e);
		}
		if(Game.state == GameState.TERRAIN) {
			handleTerrainInput(e);
		}
	}
	
	public static void handleSpaceInput(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP && SpaceControls.forward) {
			SpaceControls.forward = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN && SpaceControls.back) {
			SpaceControls.back = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && SpaceControls.right) {
			SpaceControls.right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT && SpaceControls.left) {
			SpaceControls.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE && SpaceControls.shoot) {
			SpaceControls.shoot = false;
		}
	}
	
	public static void handleTerrainInput(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP && TerrainControls.forward) {
			TerrainControls.forward = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN && TerrainControls.back) {
			TerrainControls.back = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && TerrainControls.right) {
			TerrainControls.right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT && TerrainControls.left) {
			TerrainControls.left = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE && SpaceControls.shoot) {
			TerrainControls.shoot = false;
		}
	}
	
}
