package behaviour;

import controls.TerrainControls;
import main.Game;
import planet.BlockType;
import settings.Settings;

public class TerrainBehaviour {

	public static void handleControls() {
		TerrainControls.handleControls();
	}

	public static void handlePlayer(long delta) {
		Game.player.handlePhysics(delta);
	}
	
	public static void handleCamera(long delta) {
		Game.player.cam.handleCamera(Game.player, delta);
	}
}
