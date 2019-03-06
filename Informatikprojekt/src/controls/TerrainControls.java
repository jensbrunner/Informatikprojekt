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
			Game.player.vel.x = -Settings.playerWalkSpeed;
		}else if(right) {
			Game.player.vel.x = Settings.playerWalkSpeed;
		}else {
			Game.player.vel.x = 0;
		}
		if(forward) {
			if(Game.player.canJump) {
				Game.player.vel.y = -Settings.playerJumpSpeed;
			}
			Game.player.canJump = false;
		}
		if(back) {
			
		}
		if(forward || back || left || right) {
			any = true;
		}else {
			any = false;
		}
	}
}
