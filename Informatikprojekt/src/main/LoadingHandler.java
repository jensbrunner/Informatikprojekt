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
			
			Game.player.cam.starsDone = false;
			
			//populate the map with stars
			for(int i = 0; i < Settings.totalStars; i++) {
				Game.player.cam.stars.add(new Vector2((Math.random() > 0.5 ? -1 : 1) * Math.random()*10000, (Math.random() > 0.5 ? -1 : 1) * Math.random()*10000));
			}
			
			Game.player.cam.starsDone = true;
		}

		//setup player
		Game.player.rocket = new RocketPlayer(new Vector2(Settings.startPos.x,Settings.startPos.y));

		//add planets if empty
		if(Settings.planets.isEmpty()) {
			for (int x = 0; x < Settings.numberOfPlanets; x++ ) {
				int diameter = (int)(100 + Math.random()*200);//have to cast the value to a integer
				
				Planet newPlanet = new Planet(new Vector2((Math.random() > 0.5 ? -1 : 1)*Math.random()*10000, (Math.random() > 0.5 ? -1 : 1)*Math.random()*10000) , diameter, PlanetType.DEFAULT);
				
				//Make sure non-overlap
				boolean hasOverlap = false;
				for(Planet p : Settings.planets) {
					if(p.pos.subtract(newPlanet.pos).mag() < p.diameter/2 + newPlanet.diameter/2) {
						hasOverlap = true;
						break;
					}
				}
				if(!hasOverlap) {
					Settings.planets.add(newPlanet);
				}
			}
		}
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
