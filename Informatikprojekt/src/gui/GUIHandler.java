package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.Game;
import main.GameState;
import settings.Settings;

public class GUIHandler {

	public static void doGUI(JPanel panel) {
		if(Game.state == GameState.TERRAIN) {
			GUIHandler.doTerrainGUI(panel);
		}
	}
	
	public static void doTerrainGUI(JPanel panel) {
		JButton takeOffButton = new JButton();
		takeOffButton.setText("Take Off");
		takeOffButton.setBounds(10, 10, 100, 100);
		takeOffButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.switchState(GameState.SPACE, Game.player.curPlanet);
			}
			
		});
		takeOffButton.setVisible(true);
		panel.add(takeOffButton);
	}
	
}
