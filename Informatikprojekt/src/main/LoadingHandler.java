package main;

import java.util.concurrent.ThreadLocalRandom;

import entity.Enemy;
import planet.Planet;
import planet.PlanetType;
import player.Camera;
import player.RocketPlayer;
import settings.Settings;
import terrain.TerrainGenerator;
import terrain.TerrainTools;
import tools.Vector2;

public class LoadingHandler {

	public static void loadSpace() {
		Game.player.cam.center(Game.player.rocket.pos);

		//random stars aesthetic
		if(Game.player.cam.stars.isEmpty()) {
			
			Game.player.cam.starsDone = false;
			
			//populate the map with stars
			for(int i = 0; i < Settings.totalStars; i++) {
				Game.player.cam.stars.add(new Vector2((Math.random() > 0.5 ? -1 : 1) * Math.random()*10000, (Math.random() > 0.5 ? -1 : 1) * Math.random()*10000));
			}
			
			Game.player.cam.starsDone = true;
		}

		//add planets if empty
		if(Settings.planets.isEmpty()) {
			for (int x = 0; x < Settings.numberOfPlanets; x++ ) {
				
				//type of the planet
				int type = ThreadLocalRandom.current().nextInt(0, 2+1);
				
				int diameter = (int)(80 + Math.random()*400);//have to cast the value to a integer
				
				Planet newPlanet = new Planet(new Vector2((Math.random() > 0.5 ? -1 : 1)*Math.random()*10000, (Math.random() > 0.5 ? -1 : 1)*Math.random()*10000) , diameter, type);
				
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
					TerrainGenerator.populateMap(newPlanet);
				}
			}
		}
	}

	public static void loadTerrain(Planet p) {
		
		//add enemies if not already an appropriate number
		int targetEnemies = (int)((p.diameter/200.0) * Settings.enemyCount);
		if(p.enemies.size() < targetEnemies) {
			int howMany = targetEnemies-p.enemies.size();
			for(int i = 0; i < howMany; i++) {
				int randX = (int) (Math.random() * p.sizeX);
				Vector2 pos = new Vector2(randX*Settings.blockSize, TerrainTools.highestYAtX(p, randX)*Settings.blockSize-Settings.enemySize);
				Enemy e = new Enemy(Settings.enemySize, pos, p);
				p.enemies.add(e);
			}
		}

		Game.player.pos = new Vector2((p.sizeX/2)*Settings.blockSize,TerrainTools.highestYAtX(p, p.sizeX/2)*Settings.blockSize);

		Game.player.cam.center(Game.player.pos);
	}
}
