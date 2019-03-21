package behaviour;

import ai.AIHandler;
import controls.TerrainControls;
import controls.TerrainMouse;
import entity.EntityHandler;
import main.Game;

public class TerrainBehaviour {

	public static void handleControls(long delta) {
		TerrainControls.handleControls(delta);
		TerrainMouse.handleMouse();
	}

	public static void handlePlayer(long delta) {
		Game.player.handle(delta);
	}
	
	public static void handleCamera(long delta) {
		Game.player.cam.handleCamera(Game.player, delta);
	}
	
	public static void handleEnemies(long delta) {
		AIHandler.handleAIOnPlanet(Game.player.curPlanet, delta);
	}
	
	public static void handleShots(long delta) {
		EntityHandler.handleEntities(delta);
	}
}
