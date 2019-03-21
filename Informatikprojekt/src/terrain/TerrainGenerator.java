package terrain;

import planet.BlockType;
import planet.Planet;
import planet.PlanetType;
import settings.Settings;

public class TerrainGenerator {

	public static void populateMap(Planet p) {

		if(p.type == PlanetType.DEFAULT) {
			for(int x = 0; x < p.sizeX; x++) {
				for(int y = 0; y < Settings.planetHeight; y++) {
					if(y > 30) {
						p.map[x][y] = BlockType.DIRT;
						
						
					}else {
						p.map[x][y] = BlockType.AIR;
					}
				}
			}
		}
		
		if(p.type == PlanetType.MOUNTAIN) {
			for(int x = 0; x < p.sizeX; x++) {
				for(int y = 0; y < Settings.planetHeight; y++) {
					if(y > 30) {
						p.map[x][y] = BlockType.ROCK;
						double rand = Math.random();
						if(rand <= 0.0001) {
							p.map[x][y] = BlockType.EXOTIUM;
						}else if(rand <= 0.001) {
							p.map[x][y] = BlockType.GOLD;
						}
					}else {
						p.map[x][y] = BlockType.AIR;
					}
				}
			}
		}
		
		if(p.type == PlanetType.WATER) {
			for(int x = 0; x < p.sizeX; x++) {
				for(int y = 0; y < Settings.planetHeight; y++) {
					if(y > 30) {
						p.map[x][y] = BlockType.WATER;
					}else {
						p.map[x][y] = BlockType.AIR;
					}
				}
			}
		}
	}
}
