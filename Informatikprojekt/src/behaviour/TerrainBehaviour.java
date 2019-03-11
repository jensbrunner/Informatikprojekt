package behaviour;

import controls.TerrainControls;
import controls.TerrainMouse;
import main.Game;

public class TerrainBehaviour {

	public static void handleControls() {
		TerrainControls.handleControls();
		TerrainMouse.handleMouse();
	}

	public static void handlePlayer(long delta) {
		Game.player.handlePhysics(delta);
	}
	
	public static void handleCamera(long delta) {
		Game.player.cam.handleCamera(Game.player, delta);
	}
}
