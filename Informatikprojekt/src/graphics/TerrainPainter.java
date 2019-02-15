package graphics;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Game;
import planet.BlockType;
import planet.Planet;
import settings.Settings;

public class TerrainPainter {

	public static void paintBackground(Graphics2D g2) {
		g2.setColor(Settings.skyColor);
		g2.fillRect(0, 0, Settings.screenWidth, Settings.screenHeight);
	}

	public static void paintPlayer(Graphics2D g2) {
		g2.setColor(Settings.playerColor);
		g2.fillRect((int)(Game.player.pos.x-Game.player.cam.offset.x), (int)(Game.player.pos.y-Game.player.cam.offset.y), Settings.playerWidth, Settings.playerHeight);
	}

	public static void paintBlocks(Graphics2D g2) {
		for(int x = 0; x < Settings.planetWidth; x++) {
			for(int y = 0; y < Settings.planetHeight; y++) {
				
				int id = Game.player.curPlanet.map[x][y];
				
				if(id == BlockType.AIR) g2.setColor(Settings.skyColor);
				if(id == BlockType.DIRT) g2.setColor(Settings.defaultColor);
				
				g2.fillRect(x*Settings.blockSize-(int)Game.player.cam.offset.x, y*Settings.blockSize-(int)Game.player.cam.offset.y, Settings.blockSize, Settings.blockSize);
			}
		}
	}
}
