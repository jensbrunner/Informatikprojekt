package main;

import planet.Planet;
import planet.PlanetType;
import player.Camera;
import player.RocketPlayer;
import settings.Settings;
import terrain.TerrainGenerator;
import tools.Vector2;

public class LoadingHandler {

	public static void jens() {
		
	}
	
	public static void loadSpace() {
		//create camera
		Game.player.cam = new Camera();
		
		//random stars (individual for each player)
		if(Game.player.cam.stars.isEmpty()) {
			
			//populate the map with stars
			for(int i = 0; i < Settings.totalStars; i++) {
				Game.player.cam.stars.add(new Vector2((Math.random() > 0.5 ? -1 : 1) * Math.random()*10000, (Math.random() > 0.5 ? -1 : 1) * Math.random()*10000));
			}
		}
				
		//setup player
		Game.player.rocket = new RocketPlayer(new Vector2(Settings.startPos.x,Settings.startPos.y));
						
		//add planets
		for (int x = 0; x < Settings.numberOfPlanets; x++ ) {
			int diameter = (int)(100 + Math.random()*200);//have to cast the value to a integer
			Settings.planets.add(new Planet(new Vector2((Math.random() > 0.5 ? -1 : 1)*Math.random()*10000, (Math.random() > 0.5 ? -1 : 1)*Math.random()*10000) , diameter, PlanetType.DEFAULT));
		}
	}
	
	public static void Stefan() {
		
	}
	
	public static void loadTerrain(Planet p) {
		//create camera
		Game.player.cam = new Camera();
		
		Game.player.pos = new Vector2(200*Settings.blockSize,28*Settings.blockSize-Settings.playerHeight);
		
		Game.player.cam.center(Game.player.pos);
		
		//generate first-time
		TerrainGenerator.populateMap(p);
	}
}
