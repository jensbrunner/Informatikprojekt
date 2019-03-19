package collision;

import entity.Enemy;
import player.Player;
import settings.Settings;
import tools.Vector2;

public class CollisionDetector {

	public static boolean doesPlayerCollideWithBlock(Player p, int x, int y) {
		AABB playerBox = new AABB(p.pos.subtract(new Vector2(0, Settings.playerHeight)), Settings.playerHeight, Settings.playerWidth);
		
		return collidesWithBlock(playerBox, x, y);
	}
	
	public static boolean doesEnemyCollideWithBlock(Enemy p, int x, int y) {
		AABB playerBox = new AABB(p.pos.subtract(new Vector2(0, p.size)), p.size, p.size);
		
		return collidesWithBlock(playerBox, x, y);
	}
	
	public static boolean collidesWithBlock(AABB a, int x, int y) {
		AABB cellBox = new AABB(new Vector2(x*Settings.blockSize, y*Settings.blockSize), Settings.blockSize, Settings.blockSize);
		
		return a.collides(cellBox);
	}
	
	public static Vector2 getPlayerCollisionData(Player p, int x, int y) {
		AABB playerBox = new AABB(p.pos.subtract(new Vector2(0, Settings.playerHeight)), Settings.playerHeight, Settings.playerWidth);
		AABB cellBox = new AABB(new Vector2(x*Settings.blockSize, y*Settings.blockSize), Settings.blockSize, Settings.blockSize);
		
		return playerBox.getCollisionData(cellBox);
	}
	
	public static Vector2 getEnemyCollisionData(Enemy p, int x, int y) {
		AABB playerBox = new AABB(p.pos.subtract(new Vector2(0, p.size)), p.size, p.size);
		AABB cellBox = new AABB(new Vector2(x*Settings.blockSize, y*Settings.blockSize), Settings.blockSize, Settings.blockSize);
		
		return playerBox.getCollisionData(cellBox);
	}
}
