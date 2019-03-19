package ai;

import java.util.ArrayList;

import entity.Enemy;
import planet.Planet;

public class AIHandler {
	
	public static void handleAIOnPlanet(Planet p, long delta) {
		for(Enemy e : p.enemies) {
			e.handle(delta);
		}
	}
}
