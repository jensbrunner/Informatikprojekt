package terrain;

import planet.BlockType;
import planet.Planet;
import settings.Settings;
import tools.Vector2;

public class TerrainTools {
	
	public static int getCellX(double x) {
		return (int)(x/Settings.blockSize);
	}
	
	public static int getCellY(double y) {
		return (int)(y/Settings.blockSize);
	}
	
	public static double heightAboveGround(Vector2 pos, Planet p) {
		
		for(int y = TerrainTools.getCellY(pos.x); y <= Settings.planetHeight; y++) {
			if(p.map[TerrainTools.getCellX(pos.y)][y] == BlockType.DIRT){
				return y*Settings.blockSize-pos.y;
			}
		}
		return Double.NaN;
	}
	
	public static int highestYAtX(Planet p, int x) {
		for(int y = 0; y < p.sizeY; y++) {
			if(TerrainTools.isSolid(p, x, y) || TerrainTools.isFluid(p, x, y)) {
				return y-1;
			}
		}
		return -1;
	}
	
	public static boolean isSolid(Planet p, int x, int y) {
		int id = p.map[x][y];
		if(id == BlockType.DIRT || id == BlockType.ROCK) return true;
		return false;
	}
	
	public static boolean isFluid(Planet p, int x, int y) {
		int id = p.map[x][y];
		if(id == BlockType.WATER) return true;
		return false;
	}
	
	public static boolean doesBlockExist(Planet p, int x, int y) {
		if(x >= p.sizeX || x < 0 || y >= Settings.planetHeight || y < 0) {
			return false;
		}
		return true;
	}
	
}
