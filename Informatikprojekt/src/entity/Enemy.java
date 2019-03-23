package entity;

import collision.CollisionDetector;
import inventory.Item;
import main.Game;
import main.GameState;
import planet.Planet;
import player.Player;
import settings.Settings;
import terrain.TerrainTools;
import tools.Vector2;

public class Enemy {

	public int size, health = 100;
	public Vector2 pos, vel;
	public Planet planet;
	
	public boolean isDead = false;
	public double speedModifier;
	public Player target;
	public int behaviour; //0 = idle, 1 = left, 2 = right, 3 = chasing
	public long lastBehaviourChange;
	
	public Enemy(int size, Vector2 pos, Planet planet) {
		this.size = size;
		this.pos = new Vector2(pos.x, pos.y);
		this.vel = new Vector2(0, 0);
		this.planet = planet;
		this.speedModifier = 0.5 + Math.random()*0.5;
		
		changeBehaviour(0);
	}
	
	public void handle(long delta) {
		delta = delta == 0 ? 1 : delta;
		
		handleHealth();
		handleBehaviour();
		handleAttack();
		handleTeleport();
		handleGravity(delta);
		handleFluid(delta);
		handleCollisions(delta);

		pos.x += vel.x*(delta/1000.0);
		pos.y += vel.y*(delta/1000.0);
	}
	
	private void handleBehaviour() {
		
		if(behaviour != 3 && pos.add(new Vector2(size/2, size/2)).subtract(Game.player.pos.add(Settings.playerOffset)).mag() <= Settings.lockOnDistance) {
			target = Game.player;
			changeBehaviour(3);
		}
		
		if(behaviour == 0) {
			
			vel.x = 0;
			
			if(System.currentTimeMillis() - lastBehaviourChange > Settings.enemyBehaviourTime) {
				double rand = Math.random();
				if(rand < 0.3) {
					changeBehaviour(1);
				}else if(rand < 0.6){
					changeBehaviour(2);
				}
			}
			
		}else if(behaviour == 1) {
			
			vel.x = -Settings.enemyWalkSpeed*speedModifier;
			
			if(System.currentTimeMillis() - lastBehaviourChange > Settings.enemyBehaviourTime) {
				double rand = Math.random();
				if(rand < 0.3) {
					changeBehaviour(0);
				}else if(rand < 0.4) {
					changeBehaviour(2);
				}
			}
			
		}else if(behaviour == 2) {
			
			vel.x = Settings.enemyWalkSpeed*speedModifier;
			
			if(System.currentTimeMillis() - lastBehaviourChange > Settings.enemyBehaviourTime) {
				double rand = Math.random();
				if(rand < 0.3) {
					changeBehaviour(0);
				}else if(rand < 0.4) {
					changeBehaviour(1);
				}
			}
			
		}else if(behaviour == 3) {
			
			//if target to left
			if(target.pos.x+Settings.playerWidth/2 < pos.x+size/2) {
				vel.x = -Settings.enemyRunSpeed*speedModifier;
			}else {
				vel.x = Settings.enemyRunSpeed*speedModifier;
			}
			
			//Disengage if player is out of lockon distance
			if(pos.add(new Vector2(size/2, size/2)).subtract(target.pos.add(new Vector2(Settings.playerWidth/2, Settings.playerHeight/2))).mag() > Settings.lockOnDistance) {
				target = null;
				changeBehaviour(0);
			}
		}
	}
	
	private void handleAttack() {
		if(behaviour == 3 && pos.add(new Vector2(size/2, size/2)).subtract(target.pos.add(new Vector2(Settings.playerWidth, Settings.playerHeight))).mag() < Settings.hitDistance) {
			if(System.currentTimeMillis() - target.lastDamage > Settings.playerDamageCooldown) {
				target.damage(Settings.enemyDamage);
			}
		}
	}
	
	private void handleTeleport() {
		int x = TerrainTools.getCellX(pos.x);
		
		if(x == planet.sizeX-2) {
			pos.x = 2*Settings.blockSize;
		}else if(x == 1) {
			pos.x = (planet.sizeX-2)*Settings.blockSize;
		}
	}
	
	private void handleGravity(long delta) {
		vel.y += Settings.planetGravAcc*(delta/1000.0);
	}
	
	private void handleFluid(long delta) {
		int x = TerrainTools.getCellX(pos.x);
		int y = TerrainTools.getCellY(pos.y);
		
		if(TerrainTools.doesBlockExist(planet, x, y) && TerrainTools.isFluid(planet, x, y)) {
			
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
				if(!TerrainTools.doesBlockExist(planet, x, y)) continue;
					
				if(TerrainTools.isSolid(planet, x, y)) {
					if(CollisionDetector.doesEnemyCollideWithBlock(this, x, y)) {
						
						Vector2 data = CollisionDetector.getEnemyCollisionData(this, x, y);
						
						if(Math.abs(data.y) < Math.abs(data.x)) {
							this.pos.y -= data.y;
							this.vel.y = 0;
						}else {
							this.pos.x -= data.x - vel.x * (delta/1000.0);
							
							//SPECIAL ENEMY JUMPS WHEN COLLIDES HORIZONTALLY
							this.vel.y = -Settings.enemyJumpSpeed;
						}
					}
				}
			}
		}
	}
	
	private void changeBehaviour(int state) {
		behaviour = state;
		lastBehaviourChange = System.currentTimeMillis();
	}
	
	private void handleHealth() {
		if(!isDead && health < 0) {
			isDead = true;
			Game.player.inv.addItem(Item.LEATHER, 2);
		}
	}
}
