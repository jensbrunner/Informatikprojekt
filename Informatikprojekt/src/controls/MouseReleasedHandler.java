package controls;

import java.awt.event.MouseEvent;

import main.Game;
import main.GameState;

public class MouseReleasedHandler {

	public static void handleInput(MouseEvent e) {
		if(Game.state == GameState.TERRAIN) {
			handleTerrainInput(e);
		}
	}
	
	public static void handleTerrainInput(MouseEvent e) {
		TerrainMouse.mousePos.x = e.getX();
		TerrainMouse.mousePos.y = e.getY();
		
		if(e.getButton() == MouseEvent.BUTTON1) {
			TerrainMouse.lclick = false;
		}
		
		if(e.getButton() == MouseEvent.BUTTON3) {
			TerrainMouse.rclick = false;
		}
	}
	
}