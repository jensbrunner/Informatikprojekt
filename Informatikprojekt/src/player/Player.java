package player;

import collision.CollisionDetector;
import inventory.Inventory;
import main.Game;
import main.GameState;
import planet.Planet;
import settings.Settings;
import terrain.TerrainTools;
import tools.Vector2;

public class Player {

	//Make use of the RocketPlayer object when in space.
	public RocketPlayer rocket;
	public Planet curPlanet;
	public Camera cam;
	public Inventory inv;
	
	public Vector2 pos;
	public Vector2 vel;

	public long lastDestroy;
	
	public int charge = 50;
	public int health = 100;
	public long lastDamage;

	public boolean canJump = true;

	public Player() {
		this.pos = new Vector2(Settings.startPos.x, Settings.startPos.y);
		this.vel = new Vector2(0,0);
	}

	public void handle(long delta) {
		delta = delta == 0 ? 1 : delta;

		handleHealth();
		handleTeleport();
		handleGravity(delta);
		handleFluid(delta);
		handleCollisions(delta);

		pos.x += vel.x*(delta/1000.0);
		pos.y += vel.y*(delta/1000.0);
	}

	private void handleTeleport() {
		int x = TerrainTools.getCellX(pos.x);

		if(x == curPlanet.sizeX-30) {
			pos.x = (30+2)*Settings.blockSize;
			cam.center(pos);
		}else if(x == 30) {
			pos.x = (curPlanet.sizeX-30-2)*Settings.blockSize;
			cam.center(pos);
		}
	}

	private void handleGravity(long delta) {
		if(pos.y >= Settings.blockSize*(curPlanet.sizeY+2)) {
			health -= 10;
		}
		vel.y += Settings.planetGravAcc*(delta/1000.0);
	}

	private void handleFluid(long delta) {
		int x = TerrainTools.getCellX(pos.x);
		int y = TerrainTools.getCellY(pos.y);

		if(TerrainTools.doesBlockExist(curPlanet, x, y) && TerrainTools.isFluid(curPlanet, x, y)) {
			canJump = true;

			//Simulate buoyancy
			vel.y -= Settings.fluidAcc*(delta/1000.0);

			//Drag
			vel.y *= 0.98;
		}
	}

	private void handleCollisions(long delta) {
		int xCoord = TerrainTools.getCellX(pos.x);
		int yCoord = TerrainTools.getCellY(pos.y);

		for(int x = xCoord-2; x <=  xCoord+2; x++) {
			for(int y = yCoord-3; y <= yCoord+1; y++) {

				//Make sure we only check blocks that exist
				if(!TerrainTools.doesBlockExist(curPlanet, x, y)) continue;

				if(TerrainTools.isSolid(curPlanet, x, y)) {
					if(CollisionDetector.doesPlayerCollideWithBlock(this, x, y)) {

						Vector2 data = CollisionDetector.getPlayerCollisionData(this, x, y);

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
	
	public void damage(int amount) {
		health -= amount;
		Game.gui.healthLabel.setText("Health: " + health + "/100");
		System.out.println(health);
		lastDamage = System.currentTimeMillis();
	}
	
	private void handleHealth() {
		if(health < 0) {
			Game.switchState(GameState.GAMEOVER, curPlanet);
		}
	}
}
