package ai;

import java.util.ArrayList;

import entity.Enemy;
import planet.Planet;

public class AIHandler {
	
	public static void handleAIOnPlanet(Planet p, long delta) {
		
		ArrayList<Enemy> toRemove = new ArrayList<Enemy>();
		
		for(Enemy e : p.enemies) {
			if(e.isDead) toRemove.add(e);
			
			e.handle(delta);
		}
		
		for(Enemy e : toRemove) {
			p.enemies.remove(e);
		}
	}
}
