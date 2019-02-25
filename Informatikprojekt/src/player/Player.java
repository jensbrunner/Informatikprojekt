package player;

import collision.AABB;
import planet.Planet;
import settings.Settings;
import terrain.TerrainTools;
import tools.Vector2;

public class Player {

	//Make use of the RocketPlayer object when in space.
	public RocketPlayer rocket;
	public Planet curPlanet;
	public Camera cam;
	
	public Vector2 pos;
	public Vector2 vel;
	
	public Player() {
		this.pos = new Vector2(Settings.startPos.x, Settings.startPos.y);
		this.vel = new Vector2(0,0);
	}
	
	public void handlePhysics(long delta) {
		delta = delta == 0 ? 1 : delta;
		
		handleGravity(delta);
				
		pos.x += vel.x*(delta/1000.0);
		pos.y += vel.y*(delta/1000.0);
	}
	
	public void handleGravity(long delta) {
		double dist = TerrainTools.heightAboveGround(pos, curPlanet);
		if(dist > 0.0) {
			vel.y += Settings.planetGravAcc*(delta/1000.0);
		}else {
			if(vel.y > 0) vel.y = 0;
			pos.y = TerrainTools.getCellY(pos)*Settings.blockSize;
		}
	}
	
	public boolean collidesWith(int cellX, int cellY) {
		AABB playerBox = new AABB(pos.subtract(new Vector2(0, Settings.playerHeight)), Settings.playerHeight, Settings.playerWidth);
		return false;
	}
}
