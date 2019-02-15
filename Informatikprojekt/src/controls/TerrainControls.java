package controls;

import main.Game;
import settings.Settings;
import tools.Vector2;

public class TerrainControls {

public static boolean left = false, right = false, forward = false, back = false, any = false;
	
	public static boolean shoot = false;
	public static long lastShoot = -1;
	
	public static void handleControls() {
		if(left) {
			Game.player.vel.x = -Settings.playerWalkSpeed*10;
		}
		if(right) {
			Game.player.vel.x = Settings.playerWalkSpeed*10;
		}
		if(forward) {
			Game.player.vel.y = -Settings.playerWalkSpeed*10;
		}
		if(back) {
			Game.player.vel.y = Settings.playerWalkSpeed*10;
		}
		if(forward || back || left || right) {
			any = true;
		}else {
			any = false;
			Game.player.vel = new Vector2(0,0);
		}
	}
}
