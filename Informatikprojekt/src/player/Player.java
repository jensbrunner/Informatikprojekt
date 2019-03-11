package player;

import collision.AABB;
import collision.CollisionDetector;
import controls.TerrainControls;
import main.Game;
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
	
	public boolean canJump = true;
	
	public Player() {
		this.pos = new Vector2(Settings.startPos.x, Settings.startPos.y);
		this.vel = new Vector2(0,0);
	}
	
	public void handlePhysics(long delta) {
		delta = delta == 0 ? 1 : delta;
		
		handleGravity(delta);
		handleCollisions(delta);
		//handleTeleport();
		
		pos.x += vel.x*(delta/1000.0);
		pos.y += vel.y*(delta/1000.0);
		
	}
	
	/*private void handleTeleport() {
		int x = TerrainTools.getCellX(pos);
		if (x == Settings.planetWidth-1){
			x = 1;
			return;
		}
		if (x == 0) {
			x = Settings.planetWidth-1;
			return;
		}
		pos.x = x;
	}*/
	
	private void handleGravity(long delta) {
		double dist = TerrainTools.heightAboveGround(pos, curPlanet);
		if(dist > 0.0) {
			
		}else {
			if(vel.y > 0) vel.y = 0;
			pos.y = TerrainTools.getCellY(pos)*Settings.blockSize;
		}
		vel.y += Settings.planetGravAcc*(delta/1000.0);
	}
	
	private void handleCollisions(long delta) {
		int xCoord = TerrainTools.getCellX(pos);
		int yCoord = TerrainTools.getCellY(pos);
		
		for(int x = xCoord-2; x <=  xCoord+2; x++) {
			for(int y = yCoord-3; y <= yCoord+1; y++) {
				if(TerrainTools.isSolid(curPlanet, x, y)) {
					if(CollisionDetector.doesPlayerCollideWithBlock(this, x, y)) {
						
						Vector2 data = CollisionDetector.getPlayerCollisionData(this, x, y);
						//System.out.println(data.x + " : " + data.y);
						
						if(Math.abs(data.y) < Math.abs(data.x)) {
							this.pos.y -= data.y;
							this.vel.y = 0;
							this.canJump = true;
						}else {
							this.pos.x -= data.x - vel.x * (delta/1000.0);
							this.vel.x = 0;
						}
					}
				}
			}
		}
	}
}
