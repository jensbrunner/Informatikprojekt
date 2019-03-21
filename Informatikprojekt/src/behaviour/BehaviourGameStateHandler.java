package behaviour;

import main.Game;
import main.GameState;

public class BehaviourGameStateHandler {

	public static void handleState(long delta) {
		if(Game.state == GameState.SPACE) {
			handleSpace(delta);
		}
		if(Game.state == GameState.GAMEOVER) {
			handleGameover(delta);
		}
		if(Game.state == GameState.TERRAIN) {
			handleTerrain(delta);
		}
	}
	
	public static void handleSpace(long delta) {
		
		SpaceBehaviour.handleEntities(delta);
		
		SpaceBehaviour.handleRocket(delta);
		
		SpaceBehaviour.handleCamera(delta);
		
		SpaceBehaviour.handleControls(delta);
		
		SpaceBehaviour.handleMessages();
		
		SpaceBehaviour.handleLanding();
	}
	
	public static void handleGameover(long delta) {
		
	}
	
	public static void handleTerrain(long delta) {
		
		TerrainBehaviour.handleShots(delta);
		
		TerrainBehaviour.handleEnemies(delta);
		
		TerrainBehaviour.handleControls(delta);
		
		TerrainBehaviour.handlePlayer(delta);
		
		TerrainBehaviour.handleCamera(delta);
		
	}
}
