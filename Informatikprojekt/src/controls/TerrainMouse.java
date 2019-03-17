package controls;

import java.awt.event.MouseEvent;

import collision.CollisionDetector;
import main.Game;
import planet.BlockType;
import terrain.TerrainTools;
import tools.Vector2;

public class TerrainMouse {

	public static boolean lclick = false, rclick = false;
	public static Vector2 mousePos = new Vector2(0, 0);

	public static void handleMouse() {

		int x = TerrainTools.getCellX(mousePos.x + Game.player.cam.offset.x);
		int y = TerrainTools.getCellX(mousePos.y + Game.player.cam.offset.y);

		if(TerrainTools.doesBlockExist(Game.player.curPlanet, x, y) && !CollisionDetector.doesPlayerCollideWithBlock(Game.player, x, y)) {
			if(lclick) {
				if(Game.player.curPlanet.map[x][y] != BlockType.AIR) {
					Game.player.curPlanet.map[x][y] = BlockType.AIR;
				}
			}
			if(rclick) {
				if(!TerrainTools.isSolid(Game.player.curPlanet, x, y)) {
					Game.player.curPlanet.map[x][y] = BlockType.DIRT;
				}
			}
		}
	}

}
