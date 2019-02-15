package controls;

import entity.EntityHandler;
import entity.Shot;
import main.Game;
import settings.Settings;
import tools.Tools;
import tools.Vector2;

public class SpaceControls {

	public static boolean left = false, right = false, forward = false, back = false, any = false;
	
	public static boolean shoot = false;
	public static long lastShoot = -1;
	
	public static void handleControls() {
		if(left) {
			Game.player.rocket.angle-=3;
		}
		if(right) {
			Game.player.rocket.angle+=3;
		}
		if(forward) {
			Game.player.rocket.vel.x+=Math.cos(Tools.toRads(Game.player.rocket.angle))*2;
			Game.player.rocket.vel.y+=Math.sin(Tools.toRads(Game.player.rocket.angle))*2;
		}
		if(back) {
			Game.player.rocket.vel.x-=Math.cos(Tools.toRads(Game.player.rocket.angle))*2;
			Game.player.rocket.vel.y-=Math.sin(Tools.toRads(Game.player.rocket.angle))*2;
		}
		if(forward || back) {
			any = true;
		}else {
			any = false;
		}
		
		if(shoot && System.currentTimeMillis() - lastShoot > (1000/Settings.shotsPerSec)) {
			lastShoot = System.currentTimeMillis();
			Game.player.rocket.computeVertices();
			Vector2 shotVel = new Vector2(Math.cos(Tools.toRads(Game.player.rocket.angle))*400, Math.sin(Tools.toRads(Game.player.rocket.angle))*400);
			EntityHandler.shots.add(new Shot(Game.player.rocket.nose, Game.player.rocket.vel.add(shotVel), -1 , Game.player.rocket.angle));
		}
	}
}
