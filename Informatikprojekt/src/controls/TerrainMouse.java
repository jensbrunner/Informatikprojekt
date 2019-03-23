package controls;

import collision.CollisionDetector;
import inventory.Item;
import main.Game;
import planet.BlockType;
import settings.Settings;
import terrain.TerrainTools;
import tools.Vector2;

public class TerrainMouse {

	public static boolean lclick = false, rclick = false;
	public static Vector2 mousePos = new Vector2(0, 0);

	public static void handleMouse() {

		int x = TerrainTools.getCellX(mousePos.x + Game.player.cam.offset.x);
		int y = TerrainTools.getCellX(mousePos.y + Game.player.cam.offset.y);

		if(System.currentTimeMillis() - Game.player.lastDestroy > Settings.destroyWait && TerrainTools.doesBlockExist(Game.player.curPlanet, x, y)  && (new Vector2(x*Settings.blockSize - Settings.blockSize/2, y*Settings.blockSize-Settings.blockSize/2)).subtract(Game.player.pos.add(Settings.playerOffset)).mag() <= Settings.playerReach) {
			if(lclick) {
				int id = Game.player.curPlanet.map[x][y];
				
				if(id != BlockType.AIR && TerrainTools.hasEmptyNeighbour(Game.player.curPlanet, x, y)) {
					Game.player.curPlanet.map[x][y] = BlockType.AIR;
					Game.player.lastDestroy = System.currentTimeMillis();
					
					if(id == BlockType.DIRT) {
						Game.player.inv.addItem(Item.DIRT, 1);
					}
					
					if(id == BlockType.ROCK) {
						Game.player.inv.addItem(Item.STONE, 1);
					}
					
					if(id == BlockType.GOLD) {
						Game.player.inv.addItem(Item.GOLD, 1);
					}
					
					if(id == BlockType.EXOTIUM) {
						Game.player.inv.addItem(Item.EXOTIUM, 1);
					}
				}
			}
			if(rclick) {
				if(!TerrainTools.isSolid(Game.player.curPlanet, x, y) && !CollisionDetector.doesPlayerCollideWithBlock(Game.player, x, y)) {
					
					int id = Game.player.inv.held.id;
					int amount = Game.player.inv.held.amount;
					
					if(id != -1 && TerrainTools.hasSolidNeighbour(Game.player.curPlanet, x, y)) {
						if(id == Item.DIRT && amount > 0) {
							Game.player.inv.removeItemHeld(id, 1);
							Game.player.curPlanet.map[x][y] = BlockType.DIRT;
						}
						
						if(id == Item.STONE && amount > 0) {
							Game.player.inv.removeItemHeld(id, 1);
							Game.player.curPlanet.map[x][y] = BlockType.ROCK;
						}
						
						if(id == Item.GOLD && amount > 0) {
							Game.player.inv.removeItemHeld(id, 1);
							Game.player.curPlanet.map[x][y] = BlockType.GOLD;
						}
						
						if(id == Item.EXOTIUM && amount > 0) {
							Game.player.inv.removeItemHeld(id, 1);
							Game.player.curPlanet.map[x][y] = BlockType.EXOTIUM;
						}
					}
				}
			}
		}
	}

}
