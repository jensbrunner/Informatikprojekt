package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComponent;

import main.Game;
import main.GameState;
import settings.Settings;

public class GUIItems {

	public JButton takeOffButton, inventoryButton;
	public ArrayList<JComponent> active = new ArrayList<JComponent>();
	
	public GUIItems() {
		
		takeOffButton = new JButton();
		takeOffButton.setText("Take Off");
		takeOffButton.setFocusable(false);
		takeOffButton.setBounds(10, 10, Settings.buttonWidth, Settings.buttonHeight);
		takeOffButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.switchState(GameState.SPACE, Game.player.curPlanet);
			}
		});
		
		inventoryButton = new JButton();
		inventoryButton.setText("Inventory");
		inventoryButton.setFocusable(false);
		inventoryButton.setBounds(10, 35, Settings.buttonWidth, Settings.buttonHeight);
		inventoryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Game.inventory.setVisible(!Game.inventory.isVisible());
			}
		});
	}
	
	public void addItem(JComponent item) {
		Game.frame.add(item);
		active.add(item);
	}
	
	public void removeItem(JComponent item) {
		Game.frame.remove(item);
		active.remove(item);
	}
	
	public void removeAllItems() {
		Iterator<JComponent> iterator = active.iterator();
		while(iterator.hasNext()) {
			Game.frame.remove(iterator.next());
		}
	}
}
