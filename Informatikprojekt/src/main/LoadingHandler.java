package main;

import planet.Planet;
import planet.PlanetType;
import player.Camera;
import player.RocketPlayer;
import settings.Settings;
import terrain.TerrainGenerator;
import tools.Vector2;

public class LoadingHandler {

	public static void loadSpace() {
		//create camera
		Game.player.cam = new Camera();
		
		//random stars (individual for each player)
		if(Game.player.cam.stars.isEmpty()) {
			
			//populate the map with stars
			for(int i = 0; i < Settings.totalStars; i++) {
				Game.player.cam.stars.add(new Vector2((Math.random() > 0.5 ? -1 : 1)*Math.random()*10000, (Math.random() > 0.5 ? -1 : 1)*Math.random()*10000));
			}
		}
				
		//setup player
		Game.player.rocket = new RocketPlayer(new Vector2(Settings.startPos.x,Settings.startPos.y));
						
		//add planets
		Settings.planets.add(new Planet(new Vector2(0, 100), 200, PlanetType.DEFAULT));
	}
	
	public static void loadTerrain(Planet p) {
		//create camera
		Game.player.cam = new Camera();
		
		Game.player.pos = new Vector2(0,600);
		
		Game.player.cam.center(Game.player);
		
		//generate first-time
		TerrainGenerator.populateMap(p);
	}
}
