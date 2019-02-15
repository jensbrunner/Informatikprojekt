package player;

import planet.Planet;
import settings.Settings;
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
		
		pos.x+=vel.x*(delta/1000.0);
		pos.y+=vel.y*(delta/1000.0);
	}
}
