package graphics;

import java.awt.Graphics2D;

import main.Game;
import planet.BlockType;
import settings.Settings;

public class TerrainPainter {

	public static void paintBackground(Graphics2D g2) {
		g2.setColor(Settings.skyColor);
		g2.fillRect(0, 0, Settings.screenWidth, Settings.screenHeight);
	}

	public static void paintPlayer(Graphics2D g2) {
		g2.setColor(Settings.playerColor);
		g2.fillRect((int)Math.round(Game.player.pos.x-Game.player.cam.offset.x), (int)Math.round(Game.player.pos.y-Settings.playerHeight-Game.player.cam.offset.y), Settings.playerWidth, Settings.playerHeight);
	}

	public static void paintBlocks(Graphics2D g2) {
		for(int x = 0; x < Game.player.curPlanet.sizeX; x++) {
			for(int y = 0; y < Settings.planetHeight; y++) {
				
				int id = Game.player.curPlanet.map[x][y];
				
				if(id == BlockType.DIRT) g2.setColor(Settings.defaultColor);
				if(id == BlockType.ROCK) g2.setColor(Settings.mountainColor);
				if(id == BlockType.WATER) g2.setColor(Settings.waterColor);
				
				if(id != BlockType.AIR) {
					g2.fillRect(x*Settings.blockSize-(int)Math.round(Game.player.cam.offset.x), y*Settings.blockSize-(int)Math.round(Game.player.cam.offset.y), Settings.blockSize+1, Settings.blockSize+1);
				}
			}
		}
	}
}
