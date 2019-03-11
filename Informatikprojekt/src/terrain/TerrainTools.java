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
	
	public static boolean isSolid(Planet p, int x, int y) {
		if(p.map[x][y] == 1) return true;
		return false;
	}
	
	public static boolean doesBlockExist(Planet p, int x, int y) {
		if(x >= Settings.planetWidth || x < 0 || y >= Settings.planetHeight || y < 0) {
			return false;
		}
		return true;
	}
	
}
