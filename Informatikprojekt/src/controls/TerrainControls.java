package controls;

import java.awt.MouseInfo;
import java.awt.Point;

import entity.EntityHandler;
import entity.Shot;
import main.Game;
import settings.Settings;
import terrain.TerrainTools;
import tools.Tools;
import tools.Vector2;

public class TerrainControls {

public static boolean left = false, right = false, forward = false, back = false, any = false;
	
	public static boolean shoot = false;
	public static long lastShoot = -1;
	
	public static void handleControls(long delta) {
		
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
			int x = TerrainTools.getCellX(Game.player.pos.x);
			int y = TerrainTools.getCellY(Game.player.pos.y);
			if(TerrainTools.doesBlockExist(Game.player.curPlanet, x, y) && TerrainTools.isFluid(Game.player.curPlanet, x, y)) {
				Game.player.vel.y = Settings.playerJumpSpeed*0.5;
			}
			
		}
		if(forward || back || left || right) {
			any = true;
		}else {
			any = false;
		}
		
		if(shoot && System.currentTimeMillis() - lastShoot > (1000/Settings.terrainShotsPerSec)) {
			lastShoot = System.currentTimeMillis();
			Point mousePoint = MouseInfo.getPointerInfo().getLocation();
			Vector2 mouseLoc = new Vector2(mousePoint.x, mousePoint.y).subtract(new Vector2(Game.frame.getLocation().x, Game.frame.getLocation().y+25));
			Vector2 withOff = mouseLoc.add(Game.player.cam.offset);
			Vector2 dirNorm= withOff.subtract(Game.player.pos.add(Settings.playerOffset)).norm();
			Vector2 shotVel = dirNorm.mult(delta/1000.0).mult(Settings.terrainShotSpeed);
			EntityHandler.shots.add(new Shot(Game.player.pos.add(Settings.playerOffset), Game.player.vel.add(shotVel), -1 , 0));
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
