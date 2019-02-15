package entity;

import settings.Settings;
import tools.Vector2;

public class Shot {

	public int owner;
	public long time;
	public Vector2 pos, vel;
	public double angle;
	
	public Shot(Vector2 pos, Vector2 vel, int owner, double angle) {
		this.pos = new Vector2(pos.x, pos.y);
		this.vel = new Vector2(vel.x, vel.y);
		this.owner = owner;
		this.time = System.currentTimeMillis();
		this.angle = angle;
	}
	
	public void handleShot(long delta) {
		delta = delta== 0 ? 1 : delta;
		
		pos.x+=vel.x*(delta/1000.0);
		pos.y+=vel.y*(delta/1000.0);
	}
	
	public boolean isDead(long deltaT) {
		if(System.currentTimeMillis() - time > Settings.shotLife) {
			return true;
		}
		return false;
	}
}
