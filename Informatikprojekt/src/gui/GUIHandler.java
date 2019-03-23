package gui;

import main.Game;
import main.GameState;

public class GUIHandler {

	public static void doGUI() {
		
		Game.frame.remove(Game.draw);
		
		if(Game.state == GameState.TERRAIN) {
			GUIHandler.doTerrainGUI();
		}
		
		if(Game.state == GameState.SPACE) {
			GUIHandler.doSpaceGUI();
		}
		
		if(Game.state == GameState.GAMEOVER) {
			GUIHandler.doGameoverGUI();
		}
		Game.frame.add(Game.draw);
		Game.draw.requestFocus();
	}
	
	public static void doTerrainGUI() {
		Game.gui.removeAllItems();
		Game.gui.addItem(Game.gui.takeOffButton);
		Game.gui.addItem(Game.gui.inventoryButton);
		Game.gui.addItem(Game.gui.craftingButton);
		Game.gui.addItem(Game.gui.healthLabel);
		Game.gui.addItem(Game.gui.chargeLabel);
		
	}
	
	public static void doSpaceGUI() {
		Game.gui.removeAllItems();
	}
	
	public static void doGameoverGUI() {
		Game.gui.removeAllItems();
		Game.gui.addItem(Game.gui.restartButton);
	}
	
}
