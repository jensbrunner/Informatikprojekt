package graphics;

import java.awt.Graphics2D;

import main.Game;
import main.GameState;

public class GraphicsGameStateHandler {

	public static void handleState(Graphics2D g2) {
		if(Game.state == GameState.SPACE) {
			handleSpace(g2);
		}
		
		if(Game.state == GameState.LOADING) {
			handleLoading(g2);
		}
		
		if(Game.state == GameState.TERRAIN) {
			handleTerrain(g2);
		}
	}

	public static void handleSpace(Graphics2D g2) {
		//background
		SpacePainter.paintBackground(g2);

		//planets
		SpacePainter.paintPlanets(g2);
		//draw rocket
		SpacePainter.paintRocket(g2);

		//draw shots
		SpacePainter.paintShots(g2);

		//handle then draw messages (this has to be the last to be on top, maybe below inventory)
		SpacePainter.paintMessages(g2);
	}

	public static void handleLoading(Graphics2D g2) {
		//background
		LoadingPainter.paintBackground(g2);
		
		//text
		LoadingPainter.paintText(g2);
	}
	
	public static void handleTerrain(Graphics2D g2) {
		//background/atmosphere
		TerrainPainter.paintBackground(g2);
		
		
		//blocks
		TerrainPainter.paintBlocks(g2);
		
		//player
				TerrainPainter.paintPlayer(g2);
		
	}
	
}
