package behaviour;

import controls.SpaceControls;
import entity.EntityHandler;
import main.Game;
import main.GameState;
import planet.Planet;
import player.Camera;
import player.Message;
import settings.Settings;

public class SpaceBehaviour {

	public static void handleEntities(long delta) {
		EntityHandler.handleEntities(delta);
	}
	
	public static void handleRocket(long delta) {
		Game.player.rocket.handlePhysics(delta);
	}
	
	public static void handleControls(long delta) {
		SpaceControls.handleControls(delta);
	}
	
	public static void handleCamera(long delta) {
		Game.player.cam.handleCamera(Game.player, delta);
	}
	
	public static void handleMessages() {
		Message.handleMessages();
	}
	
	public static void handleLanding() {
		for(Planet p : Settings.planets) {
			if((p.pos.subtract(Game.player.rocket.pos)).mag() < p.diameter/2) {
				System.out.println("Landed.");
				Game.player.curPlanet = p;
				Game.switchState(GameState.TERRAIN, p);
			}
		}
	}
}

