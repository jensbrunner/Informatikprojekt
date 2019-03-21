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
		if(BlockType.solids.contains(id)) return true;
		return false;
	}
	
	public static boolean isFluid(Planet p, int x, int y) {
		int id = p.map[x][y];
		if(BlockType.fluids.contains(id)) return true;
		return false;
	}
	
	public static boolean doesBlockExist(Planet p, int x, int y) {
		if(x >= p.sizeX || x < 0 || y >= Settings.planetHeight || y < 0) {
			return false;
		}
		return true;
	}
	
	public static boolean hasSolidNeighbour(Planet p, int _x, int _y) {
		for(int x = _x-1; x <= _x+1; x++) {
			for(int y = _y-1; y <= _y+1; y++) {
				if(TerrainTools.doesBlockExist(p, x, y)) {
					if(TerrainTools.isSolid(p, x, y)) return true;
				}
			}
		}
		return false;
	}
	
	public static boolean hasEmptyNeighbour(Planet p, int _x, int _y) {
		for(int x = _x-1; x <= _x+1; x++) {
			for(int y = _y-1; y <= _y+1; y++) {
				if(TerrainTools.doesBlockExist(p, x, y)) {
					if(!TerrainTools.isSolid(p, x, y)) return true;
				}
			}
		}
		return false;
	}
}
