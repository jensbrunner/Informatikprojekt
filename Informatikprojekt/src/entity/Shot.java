package entity;

import main.Game;
import main.GameState;
import settings.Settings;
import tools.Vector2;

public class Shot {

	public int owner;
	public long time;
	public Vector2 pos, vel;
	public double angle;
	public boolean isDead;
	
	public Shot(Vector2 pos, Vector2 vel, int owner, double angle) {
		this.pos = new Vector2(pos.x, pos.y);
		this.vel = new Vector2(vel.x, vel.y);
		this.owner = owner;
		this.time = System.currentTimeMillis();
		this.angle = angle;
		isDead = false;
	}
	
	public void handleShot(long delta) {
		delta = delta== 0 ? 1 : delta;
		
		handleHit();
		
		pos.x+=vel.x*(delta/1000.0);
		pos.y+=vel.y*(delta/1000.0);
	}
	
	public void handleHit() {
		if(Game.state == GameState.TERRAIN) {
			for(Enemy e : Game.player.curPlanet.enemies) {
				if(pos.subtract(e.pos.add(new Vector2(e.size/2, -e.size/2))).mag() < e.size/2.0) {
					e.health -= Settings.enemyHealth;
					isDead = true;
				}
			}
		}
		
		if(Game.state == GameState.SPACE) {
			
		}
	}
	
	public boolean isDead(long delta) {
		if(System.currentTimeMillis() - time > Settings.shotLife) {
			return true;
		}
		return false;
	}
}
