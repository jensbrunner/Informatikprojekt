package player;

import collision.AABB;
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
	
	public boolean onGround;
	
	public Player() {
		this.pos = new Vector2(Settings.startPos.x, Settings.startPos.y);
		this.vel = new Vector2(0,0);
		
		onGround =  false;
	}
	
	public void handlePhysics(long delta) {
		delta = delta == 0 ? 1 : delta;
		
		pos.x += vel.x*(delta/1000.0);
		pos.y += vel.y*(delta/1000.0);
		
		handleGravity(delta);
		handleCollisions();	
		
		
	}
	
	public void handleGravity(long delta) {
		/*double dist = TerrainTools.heightAboveGround(pos, curPlanet);
		if(dist > 0.0) {
			
		}else {
			if(vel.y > 0) vel.y = 0;
			pos.y = TerrainTools.getCellY(pos)*Settings.blockSize;
		}*/
		vel.y += Settings.planetGravAcc*(delta/1000.0);
	}
	
	public void handleCollisions() {
		int xCoord = TerrainTools.getCellX(pos);
		int yCoord = TerrainTools.getCellY(pos);
		
		for(int x = xCoord-2; x <=  xCoord+2; x++) {
			for(int y = yCoord-3; y <= yCoord+1; y++) {
				if(TerrainTools.isSolid(curPlanet, x, y)) {
					if(this.collidesWith(x, y)) {
						this.vel = new Vector2(0,0);
						Vector2 data = this.getCollisionData(x, y);
						//System.out.println(data.x + " : " + data.y);
						//this.pos.subtract(data);
					}
				}
			}
		}
	}
	
	public boolean collidesWith(int cellX, int cellY) {
		AABB playerBox = new AABB(pos.subtract(new Vector2(0, Settings.playerHeight)), Settings.playerHeight, Settings.playerWidth);
		AABB cellBox = new AABB(new Vector2(cellX*Settings.blockSize, cellY*Settings.blockSize), Settings.blockSize, Settings.blockSize);
		
		return playerBox.collides(cellBox);
	}
	
	public Vector2 getCollisionData(int cellX, int cellY) {
		AABB playerBox = new AABB(pos.subtract(new Vector2(0, Settings.playerHeight)), Settings.playerHeight, Settings.playerWidth);
		AABB cellBox = new AABB(new Vector2(cellX*Settings.blockSize, cellY*Settings.blockSize), Settings.blockSize, Settings.blockSize);
		
		return playerBox.collisionData(cellBox);
	}
}
