package player;

import java.util.ArrayList;

import main.Game;
import main.GameState;
import settings.Settings;
import tools.Vector2;

public class Camera {

	public Vector2 offset = new Vector2(-Settings.screenWidth/2, -Settings.screenHeight/2);
	public ArrayList<Vector2> stars = new ArrayList<Vector2>();

	public boolean starsDone = false;
	
	public void handleCamera(Player p, long delta) {
		if(Game.state == GameState.SPACE) {
			handleSpaceScroll(p.rocket, delta);
		}
		if(Game.state == GameState.TERRAIN) {
			handleTerrainScroll(p, delta);
		}
	}

	public void handleSpaceScroll(RocketPlayer p, long delta) {
		delta = delta == 0 ? 1 : delta;

		if(p.pos.x-offset.x > 800 && p.vel.x>0) {
			offset.x+=(delta/1000.0)*p.vel.x;
		}
		if(p.pos.x-offset.x < 200 && p.vel.x<0) {
			offset.x+=(delta/1000.0)*p.vel.x;
		}
		if(p.pos.y-offset.y > 500 && p.vel.y>0) {
			offset.y+=(delta/1000.0)*p.vel.y;
		}
		if(p.pos.y-offset.y < 200 && p.vel.y<0) {
			offset.y+=(delta/1000.0)*p.vel.y;
		}
	}

	public void handleTerrainScroll(Player p, long delta) {
		delta = delta== 0 ? 1 : delta;

		if(p.pos.x-offset.x > 800 && p.vel.x>0) {
			offset.x+=(delta/1000.0)*p.vel.x;
		}
		if(p.pos.x-offset.x < 200 && p.vel.x<0) {
			offset.x+=(delta/1000.0)*p.vel.x;
		}
		if(p.pos.y-offset.y > 500 && p.vel.y>0) {
			offset.y+=(delta/1000.0)*p.vel.y;
		}
		if(p.pos.y-offset.y < 200 && p.vel.y<0) {
			offset.y+=(delta/1000.0)*p.vel.y;
		}
	}
	
	public void center(Vector2 p) {
		offset.x += p.x - offset.x - Settings.screenWidth/2;
		offset.y += p.y - offset.y - Settings.screenHeight/2;
	}
}
