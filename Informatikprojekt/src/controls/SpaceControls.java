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
	
	public static void handleControls(long delta) {
		if(left) {
			Game.player.rocket.angle-=0.75;
		}
		if(right) {
			Game.player.rocket.angle+=0.75;
		}
		if(forward) {
			Game.player.rocket.vel.x+=Math.cos(Tools.toRads(Game.player.rocket.angle))*1;
			Game.player.rocket.vel.y+=Math.sin(Tools.toRads(Game.player.rocket.angle))*1;
		}
		if(back) {
			Game.player.rocket.vel.x-=Math.cos(Tools.toRads(Game.player.rocket.angle))*1;
			Game.player.rocket.vel.y-=Math.sin(Tools.toRads(Game.player.rocket.angle))*1;
		}
		if(forward || back) {
			any = true;
		}else {
			any = false;
		}
		
		if(shoot && System.currentTimeMillis() - lastShoot > (1000/Settings.shotsPerSec)) {
			lastShoot = System.currentTimeMillis();
			Vector2 normDir = new Vector2(Math.cos(Tools.toRads(Game.player.rocket.angle)), Math.sin(Tools.toRads(Game.player.rocket.angle))).norm();
			Vector2 shotVel = normDir.mult(delta/1000.0).mult(Settings.shotSpeed);
			EntityHandler.shots.add(new Shot(Game.player.rocket.nose, Game.player.rocket.vel.add(shotVel), -1 , Game.player.rocket.angle));
		}
	}
	
	public static void resetControls() {
		left = false;
		right = false;
		forward = false;
		back = false;
		any = false;
		shoot = false;
	}
}
