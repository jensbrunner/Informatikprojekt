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
		if(e.getKeyCode() == KeyEvent.VK_W && SpaceControls.forward) {
			SpaceControls.forward = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S && SpaceControls.back) {
			SpaceControls.back = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D && SpaceControls.right) {
			SpaceControls.right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A && SpaceControls.left) {
			SpaceControls.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE && SpaceControls.shoot) {
			SpaceControls.shoot = false;
		}
	}
	
	public static void handleTerrainInput(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W && TerrainControls.forward) {
			TerrainControls.forward = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S && TerrainControls.back) {
			TerrainControls.back = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D && TerrainControls.right) {
			TerrainControls.right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A && TerrainControls.left) {
			TerrainControls.left = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE && TerrainControls.shoot) {
			TerrainControls.shoot = false;
		}
	}
	
}
