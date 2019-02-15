package terrain;

import planet.BlockType;
import planet.Planet;
import settings.Settings;

public class TerrainGenerator {
	
	public static int count = 0;
	
	public static void populateMap(Planet p) {
		for(int x = 0; x < Settings.planetWidth; x++) {
			for(int y = 0; y < Settings.planetHeight; y++) {
				if(y > 30) {
					p.map[x][y] = BlockType.DIRT;
				}else {
					p.map[x][y] = BlockType.AIR;
				}
				count++;
			}
		}
		System.out.println(count);
	}
}
