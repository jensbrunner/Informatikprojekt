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
		Game.frame.add(Game.draw);
		Game.draw.requestFocus();
	}
	
	public static void doTerrainGUI() {
		Game.gui.removeAllItems();
		Game.gui.addItem(Game.gui.takeOffButton);
	}
	
	public static void doSpaceGUI() {
		Game.gui.removeAllItems();
	}
	
}
