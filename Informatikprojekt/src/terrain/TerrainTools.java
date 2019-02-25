package terrain;

import planet.BlockType;
import planet.Planet;
import settings.Settings;
import tools.Vector2;

public class TerrainTools {
	
	public static int getCellX(Vector2 p) {
		return (int)(p.x/Settings.blockSize);
	}
	
	public static int getCellY(Vector2 p) {
		return (int)(p.y/Settings.blockSize);
	}
	
	public static double heightAboveGround(Vector2 pos, Planet p) {
		
		for(int y = TerrainTools.getCellY(pos); y <= Settings.planetHeight; y++) {
			if(p.map[TerrainTools.getCellX(pos)][y] == BlockType.DIRT){
				return y*Settings.blockSize-pos.y;
			}
		}
		return Double.NaN;
	}
	
	public static double closestCellX(Vector2 pos, Planet p){
		double P = closestCellXP(pos, p);
		double N = closestCellXN(pos, p);
		return N < P ? N : P; 
	}
	
	public static double closestCellXP(Vector2 pos, Planet p) {
		for(int x = TerrainTools.getCellX(pos); x < Settings.planetWidth; x++) {
			if(p.map[x][TerrainTools.getCellY(pos)] == BlockType.DIRT){
				return x*Settings.blockSize-(pos.x+Settings.playerWidth);
			}
		}
		return Double.NaN;
	}
	
	public static double closestCellXN(Vector2 pos, Planet p) {
		for(int x = TerrainTools.getCellX(pos); x > 0; x--) {
			if(p.map[x][TerrainTools.getCellY(pos)] == BlockType.DIRT){
				return pos.x-(x*Settings.blockSize-Settings.blockSize);
			}
		}
		return Double.NaN;
	}
}
